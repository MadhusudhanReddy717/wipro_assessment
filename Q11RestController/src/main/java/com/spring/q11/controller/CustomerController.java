package com.spring.q11.controller;

import com.spring.q11.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/springrest/customers")
    public List<Customer> getAllCustomers() {
        return Arrays.asList(
            new Customer(101, "John", "Doe", "jdjohn@gmail.com", "121-232-3435", 1467240235069L),
            new Customer(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345", 1467240235069L),
            new Customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987", 1467240235069L)
        );
    }
}
