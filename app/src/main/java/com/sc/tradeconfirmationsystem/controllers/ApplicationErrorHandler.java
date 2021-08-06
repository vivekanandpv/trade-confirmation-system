package com.sc.tradeconfirmationsystem.controllers;

import com.sc.tradeconfirmationsystem.exceptions.AuthenticationFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationErrorHandler {
    //  Custom exceptions can be used to fine-tune the response here
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<?> handleAuthenticationFailedException() {
        return ResponseEntity.status(401).build();
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<?> handleAuthenticationFailedException() {
        return ResponseEntity.status(401).build();
    }

}