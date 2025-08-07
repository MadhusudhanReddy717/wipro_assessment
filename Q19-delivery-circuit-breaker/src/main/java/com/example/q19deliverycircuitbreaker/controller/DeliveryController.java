package com.example.q19deliverycircuitbreaker.controller;

import com.example.q19deliverycircuitbreaker.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return deliveryService.fetchAllUsers();
    }

    @GetMapping("/check-delivery")
    public String checkDelivery() {
        return deliveryService.getDeliveryStatus();
    }
}
