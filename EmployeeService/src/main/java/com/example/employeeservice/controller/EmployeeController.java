package com.example.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class EmployeeController {

    @GetMapping("/employee/info")
    public String getEmployeeInfo(@RequestHeader Map<String, String> headers) {
        StringBuilder response = new StringBuilder("Employee info returned!\n\nHeaders:\n");
        headers.forEach((key, value) -> response.append(key).append(": ").append(value).append("\n"));
        return response.toString();
    }
}
