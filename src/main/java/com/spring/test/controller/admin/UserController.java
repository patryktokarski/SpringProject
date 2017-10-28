package com.spring.test.controller.admin;

import com.spring.test.model.Role;
import com.spring.test.model.User;
import com.spring.test.models.RoleDao;
import com.spring.test.services.UserService;
import com.spring.test.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserValidator userValidator;

    @RequestMapping(value = "/list")
    public String getList(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin/users/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreate(Model model) {
        userService.prepareModelForCreate(model);
        model.addAttribute("create", true);
        return "admin/users/form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute("user") User user, BindingResult result,
                             RedirectAttributes redirectAttributes, Model model) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            userService.prepareModelForCreate(model);
            return "admin/users/form";
        }
        userService.create(user);
        redirectAttributes.addFlashAttribute("success", "User has been created");
        return "redirect:/users/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable int id, Model model) {
        userService.prepareModelForEdit(model, id);
        return "admin/users/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
                           RedirectAttributes redirectAttributes) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            userService.prepareModelForEdit(model, user.getId());
            return "admin/users/form";
        }
        userService.mergeWithExisting(user);
        redirectAttributes.addFlashAttribute("success", "Changes saved");
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String getDelete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        userService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "User deleted");
        return "redirect:/user/list";
    }

    @ModelAttribute("rolesSet")
    @Transactional
    public Set<Role> initializeRoles() {
        List<Role> roles = roleDao.getAll();
        Set<Role> roleSet = new HashSet<Role>();
        roleSet.addAll(roles);
        return roleSet;
    }

}
