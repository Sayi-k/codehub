package com.axon.core.exception;

import org.apache.http.HttpStatus;
import org.axonframework.commandhandling.CommandExecutionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage() ,LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handleException(Exception e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage() ,LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = {CommandExecutionException.class})
    public ResponseEntity<?> handleCommandExecutionException(CommandExecutionException e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage() , LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(errorResponse);
    }
}
