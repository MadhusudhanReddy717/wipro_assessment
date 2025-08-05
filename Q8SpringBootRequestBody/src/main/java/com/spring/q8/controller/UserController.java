package com.spring.q8.controller;

import com.spring.q8.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        return "User received: " +
                user.getFirstName() + " " +
                user.getLastName() + ", Age: " +
                user.getAge();
    }
}
