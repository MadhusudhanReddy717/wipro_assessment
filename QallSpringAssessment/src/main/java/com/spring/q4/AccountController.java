package com.spring.q4;

import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @GetMapping("/users/{id}/accounts")
    public AccountResponse getAccountDetails(
            @PathVariable("id") String userId,
            @RequestParam("type") String type,
            @RequestParam("status") String status
    ) {
        return new AccountResponse(userId, type, status);
    }
}
