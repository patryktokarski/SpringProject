package com.spring.test.controller.admin;

import com.spring.test.model.Role;
import com.spring.test.model.User;
import com.spring.test.dao.RoleDao;
import com.spring.test.services.ImageService;
import com.spring.test.services.UserService;
import com.spring.test.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
@Secured("ROLE_ADMIN")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserValidator userValidator;

//    @Autowired
//    ImageService imageService;

    @RequestMapping(value = "/list")
    public String getList(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin/user/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreate(Model model) {
        userService.prepareModelForCreate(model);
        model.addAttribute("create", true);
        return "admin/user/form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute("user") User user,
                             BindingResult result, RedirectAttributes redirectAttributes, Model model,
                             @RequestParam("file")MultipartFile file) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            userService.prepareModelForCreate(model);
            return "admin/user/form";
        }

//        imageService.save(file);
        userService.create(user);
        redirectAttributes.addFlashAttribute("success", "User has been created");
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable int id, Model model) {
        userService.prepareModelForEdit(model, id);
        return "admin/user/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
                           RedirectAttributes redirectAttributes) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            userService.prepareModelForEdit(model, user.getId());
            return "admin/user/form";
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
