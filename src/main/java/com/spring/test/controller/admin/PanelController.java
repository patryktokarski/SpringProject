package com.spring.test.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PanelController {

    @RequestMapping(value = "/admin")
    public String getAdminPanel(Model model) {
        return "admin/main";
    }
}
