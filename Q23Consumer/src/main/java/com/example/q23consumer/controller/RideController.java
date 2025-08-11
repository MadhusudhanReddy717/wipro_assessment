package com.example.q23consumer.controller;

import com.example.q23consumer.entity.Ride;
import com.example.q23consumer.repository.RideRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RideController {

    private final RideRepository rideRepository;

    public RideController(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @GetMapping("/rides")
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }
}
