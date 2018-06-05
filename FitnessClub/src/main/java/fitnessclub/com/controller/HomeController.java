package fitnessclub.com.controller;

import fitnessclub.com.entity.Event;
import fitnessclub.com.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcome(Model model) {

        List<Event> entities = eventService.findAll();
        model.addAttribute("entities", entities);
        return "home";
    }

}
