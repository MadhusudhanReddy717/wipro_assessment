package com.example.demo.dto;

import java.time.OffsetDateTime;

public record ErrorResponse(int status, String error, String message, OffsetDateTime timestamp) { }
