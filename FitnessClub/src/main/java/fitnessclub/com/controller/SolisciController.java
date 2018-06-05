package fitnessclub.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SolisciController {
    @GetMapping("/solisci")
    String viewAddForm(Model model) {
        return "solisci";
    }
}
