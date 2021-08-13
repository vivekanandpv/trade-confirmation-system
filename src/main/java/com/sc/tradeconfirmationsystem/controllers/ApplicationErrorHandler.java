package com.sc.tradeconfirmationsystem.controllers;

import com.sc.tradeconfirmationsystem.exceptions.AuthenticationFailedException;
import com.sc.tradeconfirmationsystem.exceptions.EmptyFileException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
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
        return ResponseEntity.badRequest().body("No file uploaded");
    }

    @ExceptionHandler(EmptyFileException.class)
    public ResponseEntity<?> handleEmptyFileException() {
        return ResponseEntity.badRequest().body("Empty file");
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> handleIOException() {
        return ResponseEntity.status(503).build();
    }

    @ExceptionHandler(ParserConfigurationException.class)
    public ResponseEntity<?> handleParserConfigurationException() {
        return ResponseEntity.badRequest().body("XML parsing failed");
    }


    @ExceptionHandler(SAXException.class)
    public ResponseEntity<?> handleSAXExceptionException() {
        return ResponseEntity.badRequest().body("Cannot read from XML file");
    }
}