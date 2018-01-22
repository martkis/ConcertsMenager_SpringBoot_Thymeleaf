package fitnessclub.com.controller;

import fitnessclub.com.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event")
    public String list(Model model) {
        model.addAttribute("entities", eventService.findAll());
        return "EventList";
    }

}
