package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RestaurantController {
    @GetMapping("/restaurants")
    public List<Map<String, String>> getRestaurants() {
        return List.of(
            Map.of("id", "1", "name", "Spice Garden", "location", "Bengaluru"),
            Map.of("id", "2", "name", "Ocean Feast", "location", "Chennai"),
            Map.of("id", "3", "name", "Hilltop Dine", "location", "Hyderabad")
        );
    }
}
