package com.spring.test.controller.admin;

import com.spring.test.model.User;
import com.spring.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list")
    public String getList(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin/users/list";
    }
}
