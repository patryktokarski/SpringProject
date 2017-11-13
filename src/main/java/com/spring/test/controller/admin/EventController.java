package com.spring.test.controller.admin;

import com.spring.test.model.Event;
import com.spring.test.services.EventService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/event")
@Secured("ROLE_ADMIN")
public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<Event> events = eventService.getAll();
        model.addAttribute("events", events);
        return "admin/event/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreate(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("create", true);
        return "admin/event/form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute("event") Event event, RedirectAttributes redirectAttributes) {
        eventService.create(event);
        redirectAttributes.addFlashAttribute("info", "Event created");
        return "redirect:/event/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable("id") int id, Model model) {
        Event event = eventService.findById(id);
        model.addAttribute("event", event);
        model.addAttribute("create", false);
        return "admin/event/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@ModelAttribute("event") Event event, RedirectAttributes redirectAttributes) {
        eventService.update(event);
        redirectAttributes.addFlashAttribute("success", "Event updated");
        return "redirect:/event/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String getDelete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        eventService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Event deleted");
        return "redirect:/event/list";
    }

}
