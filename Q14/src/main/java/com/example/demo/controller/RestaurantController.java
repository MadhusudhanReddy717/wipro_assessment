package com.example.demo.controller;

import com.example.demo.entity.Food;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.RestaurantService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping
    public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        return service.createRestaurant(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return service.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable Long id) {
        return service.getRestaurant(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        service.deleteRestaurant(id);
    }

    @PostMapping("/{id}/food")
    public Food addFood(@PathVariable Long id, @Valid @RequestBody Food food) {
        return service.addFoodToRestaurant(id, food);
    }

    @DeleteMapping("/foods/{foodId}")
    public void deleteFood(@PathVariable Long foodId) {
        service.deleteFood(foodId);
    }
}
