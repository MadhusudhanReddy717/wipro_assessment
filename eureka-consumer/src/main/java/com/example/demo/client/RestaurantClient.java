package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "restaurant-producer")
public interface RestaurantClient {
    @GetMapping("/restaurants")
    List<Map<String, String>> getRestaurants();
}
