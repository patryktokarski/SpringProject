package com.spring.test.controller.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppPanelController {

    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public String getMain() {
        return "application/main";
    }
}
