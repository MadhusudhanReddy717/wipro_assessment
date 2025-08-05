package com.spring.q7.controller;

import com.spring.q7.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@Valid @ModelAttribute("student") Student student,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        return "success";
    }
}
