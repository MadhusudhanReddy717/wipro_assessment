package com.javadeveloperzone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSSJSController {

    @GetMapping("/test")
    public String loadPage() {
        return "index";
    }
}
