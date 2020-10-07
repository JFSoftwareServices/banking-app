package com.jfsoftware.bankingapp.controller.api;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Data
@ToString
class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;

    ApiError(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    ApiError(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}