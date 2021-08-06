package com.sc.tradeconfirmationsystem.controllers;

import com.sc.tradeconfirmationsystem.exceptions.AuthenticationFailedException;
import com.sc.tradeconfirmationsystem.exceptions.EmptyFileException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import java.io.IOException;

@ControllerAdvice
public class ApplicationErrorHandler {
    //  Custom exceptions can be used to fine-tune the response here
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<?> handleAuthenticationFailedException() {
        return ResponseEntity.status(401).build();
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<?> handleMultipartException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(EmptyFileException.class)
    public ResponseEntity<?> handleEmptyFileException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> handleIOException() {
        return ResponseEntity.status(503).build();
    }
}