package com.phpn.utils;

import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.BindingResult;

@Component
public class ApplicationUtil {

    public ResponseEntity<Map<String, String>> mapErrorToResponse(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}