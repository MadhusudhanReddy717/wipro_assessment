package com.example.q22.orderservice;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public Order getOrderById(Long id) {
        return new Order(id, "Banana", 3);
    }
}
