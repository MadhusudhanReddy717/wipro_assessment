package com.spring.q3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @GetMapping("/")
    public String redirectToForm() {
        return "redirect:/register";
    }

    @GetMapping("/register")
    public String showForm() {
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        @RequestParam("email") String email,
        @RequestParam("birthday") String birthday,
        @RequestParam("profession") String profession,
        Model model
    ) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);
        model.addAttribute("birthday", birthday);
        model.addAttribute("profession", profession);
        return "result";
    }
}
