package com.example.q23consumer.service;

import com.example.q23consumer.entity.Ride;
import com.example.q23consumer.repository.RideRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final RideRepository rideRepository;
    private final ObjectMapper objectMapper;

    public KafkaConsumerService(RideRepository rideRepository, ObjectMapper objectMapper) {
        this.rideRepository = rideRepository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${app.kafka.topic}")
    public void consume(String message) {
        try {
            Ride ride = objectMapper.readValue(message, Ride.class);
            if ("DELETE".equalsIgnoreCase(ride.getOperation())) {
                rideRepository.deleteById(ride.getId());
            } else {
                rideRepository.save(ride);
            }
            System.out.println("Processed ride: " + ride.getId() + " operation: " + ride.getOperation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
