package com.example.demo.service;

import com.example.demo.entity.Food;
import com.example.demo.entity.Restaurant;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private FoodRepository foodRepo;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant getRestaurant(Long id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));
    }

    public void deleteRestaurant(Long id) {
        Restaurant r = getRestaurant(id);
        restaurantRepo.delete(r);
    }

    public Food addFoodToRestaurant(Long restaurantId, Food food) {
        Restaurant restaurant = getRestaurant(restaurantId);
        food.setRestaurant(restaurant);
        return foodRepo.save(food);
    }

    public void deleteFood(Long foodId) {
        Food food = foodRepo.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with ID: " + foodId));
        foodRepo.delete(food);
    }
}
