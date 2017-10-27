package com.spring.test.controller;

import com.spring.test.model.State;
import com.spring.test.model.User;
import com.spring.test.services.UserService;
import com.spring.test.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

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
    public String postRegister(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            userService.prepareModelForCreate(model);
            return "authentication/register";
        }
        userValidator.validate(user, result);
        userService.setRole(user,"User");
        user.setState(State.ACTIVE.getState());
        userService.create(user);
        model.addAttribute("success", "User created");
        return "authentication/login";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
