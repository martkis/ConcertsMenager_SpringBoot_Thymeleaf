package fitnessclub.com.controller;

import fitnessclub.com.entity.Event;
import fitnessclub.com.form.AssignUserForm;
import fitnessclub.com.form.EditEventForm;
import fitnessclub.com.form.EventForm;
import fitnessclub.com.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    EventService eventService;


    @GetMapping("/event")
    public String list(Model model) {
        model.addAttribute("entities", eventService.findAll());

        return "eventList";
    }

    @GetMapping("/eventList")
    String viewAddForm(Model model) {
        List<Event> entities = eventService.findAll();
        model.addAttribute("entities", entities);
        return "eventList";
    }

    @GetMapping(value = "/addEvent")
    public String addEvent(@ModelAttribute("userCommand") EventForm userCommand) {
        return "addEvent";
    }

    @PostMapping(value = "/addEvent")
    public String addEvent(@Valid @ModelAttribute("userCommand") EventForm userCommand, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addEvent";
        }

        eventService.save(userCommand);

        return "redirect:/eventList";
    }

    @GetMapping(value = "/assignUser")
    public String assignUser(@ModelAttribute("userCommand") AssignUserForm userCommand) {
        return "assignUser";
    }

    @PostMapping(value = "/assignUser")
    public String assignUser(@Valid @ModelAttribute("userCommand") AssignUserForm userCommand, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "assignUser";
        }

        eventService.assignUser(userCommand);

        return "redirect:/home";
    }

    @GetMapping("/{id}/editEvent")
    String edit(
            @PathVariable("id") Event entity,
            Model model
    ) {
        model.addAttribute("formData", new EventForm());
        model.addAttribute("object", entity);
        return "editEvent";
    }

    @PostMapping("/{id}/editEvent")
    String edit(
            @ModelAttribute("formData") EditEventForm userCommand,
            BindingResult bindingResult,
            @PathVariable("id") Event entity,
            Model model
    ) {
        model.addAttribute("object", entity);
        if (bindingResult.hasErrors()) {
            return "editEvent";
        }
        eventService.update(userCommand, entity);
        return "redirect:/eventList";
    }


    @RequestMapping(value = "/{id}/delete", method = {RequestMethod.POST})
    String delete(
            HttpServletRequest request,
            @PathVariable("id") Event entity,
            Model model
    ) {
        eventService.delete(entity);

        return "redirect:/eventList";
    }
}
