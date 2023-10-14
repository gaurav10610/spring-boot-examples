package com.example.springboot.domain.error;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;
    private String errorCode;
}
