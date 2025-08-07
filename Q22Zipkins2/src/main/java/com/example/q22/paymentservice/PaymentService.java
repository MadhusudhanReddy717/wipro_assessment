package com.example.q22.paymentservice;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public Payment getPayment(Long id) {
        return new Payment(id, 99.99, "COMPLETED");
    }
}
