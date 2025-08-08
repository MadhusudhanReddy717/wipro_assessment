package com.example.demo.controller;

import com.example.demo.client.RestaurantClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ConsumerController {
    private final RestaurantClient restaurantClient;
    public ConsumerController(RestaurantClient restaurantClient) {
        this.restaurantClient = restaurantClient;
    }
    @GetMapping("/consumer/restaurants")
    public List<Map<String, String>> fetchRestaurants() {
        return restaurantClient.getRestaurants();
    }
}
