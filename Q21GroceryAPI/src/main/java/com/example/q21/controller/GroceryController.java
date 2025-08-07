package com.example.q21.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
public class GroceryController {

    @GetMapping("/grocery/public")
    public String publicEndpoint() {
        return "Welcome to Grocery Store!";
    }

    @GetMapping("/grocery/items")
    public List<String> getItems() {
        return List.of("Apples", "Bananas", "Carrots");
    }

    @GetMapping("/grocery/orders")
    public List<String> getOrders() {
        return List.of("Order#1001", "Order#1002");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/grocery/admin")
    public String adminEndpoint() {
        return "Admin access granted!";
    }
}
