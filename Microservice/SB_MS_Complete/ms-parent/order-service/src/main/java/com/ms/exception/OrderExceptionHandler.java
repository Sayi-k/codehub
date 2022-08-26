package com.ms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public OrderExceptionResponse orderExceptionHandler(IllegalArgumentException ex){
        return OrderExceptionResponse.builder()
                .message(ex.getMessage())
                .errorCodeMessage(HttpStatus.NOT_FOUND.toString())
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public OrderExceptionResponse orderExceptionHandlerGeneric(Exception ex){
        return OrderExceptionResponse.builder()
                .message(ex.getMessage())
                .errorCodeMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .build();
    }
}
