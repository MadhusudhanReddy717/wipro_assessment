package com.example.q23producer.service;

import com.example.q23producer.dto.RideDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${app.kafka.topic}")
    private String topicName;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendRide(RideDTO ride) {
        try {
            String rideJson = objectMapper.writeValueAsString(ride);
            String key = ride.getId() != null ? String.valueOf(ride.getId()) : null;
            kafkaTemplate.send(topicName, key, rideJson);
            System.out.println("Sent to Kafka: " + rideJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
