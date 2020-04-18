package com.rajeev.playground.japancoronastats.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CoronaDetailsNotExistException.class)
    public ResponseEntity handleCoronaDetailsNotExistException(CoronaDetailsNotExistException ex) {
        log.error("Exception is thrown ", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
