package com.spring.test.controller.application;

import com.spring.test.model.Event;
import com.spring.test.model.User;
import com.spring.test.services.EventService;
import com.spring.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/app/event")
@Secured("ROLE_USER")
public class AppEventController {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list")
    public String listAvaliable(Model model, Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        List<Event> events = eventService.getEventsAvailableForUser(user.getId());
        model.addAttribute("events", events);
        return "application/event/list";
    }

    @RequestMapping(value = "/enroll/{id}", method = RequestMethod.GET)
    public String enroll(@PathVariable("id") int id, RedirectAttributes redirectAttributes, Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        Event event = eventService.findById(id);
        eventService.enrollUser(user, event);
        redirectAttributes.addFlashAttribute("success", "You have been enrolled successfully");
        return "redirect:/app/event/list";
    }

    @RequestMapping(value = "/my-events", method = RequestMethod.GET)
    public String getMyEvents(Model model, Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        List<Event> events = eventService.getEventsByEnrolledUserId(user.getId());
        model.addAttribute("events", events);
        return "application/event/userEvents";
    }


    @RequestMapping(value = "/unenroll/{id}", method = RequestMethod.GET)
    public String unenroll(@PathVariable("id") int id, RedirectAttributes redirectAttributes, Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        Event event = eventService.findById(id);
        eventService.unenrollUser(user, event);
        redirectAttributes.addFlashAttribute("success", "You have been unenrolled");
        return "redirect:/app/event/my-events";
    }
}
