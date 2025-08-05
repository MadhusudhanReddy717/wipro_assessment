package com.spring.q5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {

    @GetMapping("/example/test")
    public RedirectView redirectToTest2() {
        return new RedirectView("/example/test2");
    }

    @GetMapping("/example/test2")
    public String test2() {
        return "This is the redirect from test1";
    }
}
