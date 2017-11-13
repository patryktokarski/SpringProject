package com.spring.test.controller.application;

import com.spring.test.model.Event;
import com.spring.test.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/app/event")
@Secured("ROLE_USER")
public class AppEventController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<Event> events = eventService.getAll();
        model.addAttribute("events", events);
        return "application/event/list";
    }
}
