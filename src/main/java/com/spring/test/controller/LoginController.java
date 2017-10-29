package com.spring.test.controller;

import com.spring.test.model.PasswordToken;
import com.spring.test.model.State;
import com.spring.test.model.User;
import com.spring.test.services.EmailService;
import com.spring.test.services.PasswordTokenService;
import com.spring.test.services.UserService;
import com.spring.test.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @Autowired
    EmailService emailService;

    @Autowired
    PasswordTokenService passwordTokenService;

    @RequestMapping("/login")
    public String getLogin() {
        return "authentication/login";
    }

    @RequestMapping("/access-denied")
    public String getAccessDenied() {
        return "authentication/access-denied";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String getRegister(Model model) {
        userService.prepareModelForCreate(model);
        return "authentication/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(@ModelAttribute("user") @Valid User user, BindingResult result, Model model,
                               RedirectAttributes redirectAttributes) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            userService.prepareModelForCreate(model);
            return "authentication/register";
        }
        userService.setRole(user,"User");
        user.setState(State.ACTIVE.getState());
        userService.create(user);
        redirectAttributes.addFlashAttribute("success", "User created");
        return "redirect:/login";
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public String getForgotPassword() {
        return "authentication/forgot-password";
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public String postForgotPassword(HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) {
        User user = userService.findByEmail(request.getParameter("email"));
        if(user == null) {
            redirectAttributes.addFlashAttribute("error", "Wrong email address");
            return "redirect:/forgot-password";
        }
        String token = passwordTokenService.generateToken(user);
//        String url = request.getContextPath() + "/reset-password?id=" + user.getId() + "&token=" + token;
        String url = "localhost:8080" + "/reset-password?id=" + user.getId() + "&token=" + token;
        emailService.sendMessage(user.getEmail(), "Reset Password", url);
        redirectAttributes.addFlashAttribute("success", "Email with reset link has been sent. Check your mailbox");
        return "redirect:/forgot-password";
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.GET)
    public String getResetPassword(HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String token = request.getParameter("token");
        PasswordToken resetToken = passwordTokenService.findBToken(token);
        if((resetToken == null) || resetToken.getUser().getId() != id) {
            redirectAttributes.addFlashAttribute("error", "Wrong reset parameters");
            return "redirect:/login";
        }
        Date now = new Date();
        if((resetToken.getExpireDate().getTime() - now.getTime() <= 0)) {
            redirectAttributes.addFlashAttribute("error", "Reset token expired");
            return "redirect:/login";
        }
        model.addAttribute("token", token);
        return "authentication/reset-password";
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public String postResetPassword(HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) {
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");
        String token = request.getParameter("token");
        if(!password.equals(passwordConfirmation)) {
            model.addAttribute("error", "Given passwords does not match.");
            model.addAttribute("token", token);
            return "authentication/reset-password";
        }
        PasswordToken resetToken = passwordTokenService.findBToken(token);
        User user = resetToken.getUser();
        userService.changePassword(user, password);
        passwordTokenService.removeToken(token);
        redirectAttributes.addFlashAttribute("success",
                "Password has been changed. You can log in with new credentials.");
        return "redirect:/login";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
