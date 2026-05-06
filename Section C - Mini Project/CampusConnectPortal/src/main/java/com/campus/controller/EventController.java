package com.campus.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.campus.model.Event;
import com.campus.service.EventService;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);

        return "dashboard";
    }

    @GetMapping("/create-event")
    public String showEventForm(Model model, HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("event", new Event());
        return "create-event";
    }

    @PostMapping("/save-event")
    public String saveEvent(@ModelAttribute Event event,
                            HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        eventService.saveEvent(event);
        return "redirect:/dashboard";
    }
}