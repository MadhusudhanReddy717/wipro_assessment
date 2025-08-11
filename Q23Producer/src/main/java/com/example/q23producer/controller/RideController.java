package com.example.q23producer.controller;

import com.example.q23producer.dto.RideDTO;
import com.example.q23producer.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final KafkaProducerService kafkaProducerService;

    public RideController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public String createRide(@RequestBody RideDTO ride) {
        ride.setOperation("CREATE");
        kafkaProducerService.sendRide(ride);
        return "Ride creation request sent to Kafka.";
    }

    @PutMapping("/{id}")
    public String updateRide(@PathVariable Long id, @RequestBody RideDTO ride) {
        ride.setId(id);
        ride.setOperation("UPDATE");
        kafkaProducerService.sendRide(ride);
        return "Ride update request sent to Kafka.";
    }

    @DeleteMapping("/{id}")
    public String deleteRide(@PathVariable Long id) {
        RideDTO ride = new RideDTO();
        ride.setId(id);
        ride.setOperation("DELETE");
        kafkaProducerService.sendRide(ride);
        return "Ride deletion request sent to Kafka.";
    }

    @GetMapping("/{id}")
    public String getRide(@PathVariable Long id) {
        return "Ride details for ID " + id + " would be retrieved by Consumer service.";
    }
}
