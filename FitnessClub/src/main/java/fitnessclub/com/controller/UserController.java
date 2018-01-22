package fitnessclub.com.controller;

import fitnessclub.com.entity.User;
import fitnessclub.com.form.RegistrationFormModel;
import fitnessclub.com.service.UserService;
import fitnessclub.com.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping(value = "/registration")
    public String registration(@ModelAttribute("userCommand") RegistrationFormModel userCommand) {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@Valid @ModelAttribute("userCommand") RegistrationFormModel userCommand, BindingResult bindingResult) {
        userValidator.validate(userCommand, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userCommand);

        return "redirect:/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}