package com.spring.q4;

public class AccountResponse {
    private String userId;
    private String type;
    private String status;

    public AccountResponse(String userId, String type, String status) {
        this.userId = userId;
        this.type = type;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }
}
