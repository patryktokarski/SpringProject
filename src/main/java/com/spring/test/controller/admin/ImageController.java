package com.spring.test.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/images")
public class ImageController {

    @RequestMapping(value = "/list")
    public String getList() {
        return "admin/image/list";
    }
}
