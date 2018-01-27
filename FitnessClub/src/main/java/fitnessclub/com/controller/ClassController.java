package fitnessclub.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassController {
    @GetMapping("/classes")
    String viewAddForm(Model model) {
        return "classes";
    }
}
