package com.example.q19deliverycircuitbreaker.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryService {

    private final RestTemplate restTemplate;

    public DeliveryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "userCB", fallbackMethod = "userFallback")
    public ResponseEntity<?> fetchAllUsers() {
        String url = "http://localhost:8080/users";
        Object response = restTemplate.getForObject(url, Object.class);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<SimpleError> userFallback(Throwable throwable) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new SimpleError("Fallback: User Service is unavailable."));
    }

    public String getDeliveryStatus() {
        return "Delivery Service is UP";
    }
}
