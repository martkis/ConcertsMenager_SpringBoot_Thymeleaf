package fitnessclub.com.controller;

import fitnessclub.com.entity.Room;
import fitnessclub.com.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller()
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/room")
    String list(Model model) {
        List<Room> entities = roomService.findAll();
        model.addAttribute("entities", entities);
        return "room/list";
    }

    @GetMapping("/room/add")
    String viewAddForm(Model model) {
        return "room/add";
    }

    @PostMapping("/room/add")
    String performAdd(Model model) {
        return "home";
    }

    @GetMapping("/room/{id}/delete")
    String viewDeleteForm(Model model) {
        return "room/list";
    }

    @PostMapping("/room/{id}/delete")
    String delete(Model model) {
        return "room/list";
    }

    @GetMapping("/room/{id}/edit")
    String viewEditForm(Model model) {
        return "room/list";
    }

    @PostMapping("/room/{id}/edit")
    String edit(Model model) {
        return "room/list";
    }

}
