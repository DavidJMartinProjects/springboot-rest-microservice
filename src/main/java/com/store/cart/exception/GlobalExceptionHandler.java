package com.store.cart.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author david
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ErrorResponse> handleRestTemplateException(EntityNotFoundException exception, HttpServletRequest request) {
        return new ResponseEntity<ErrorResponse>(
                ErrorResponse.builder()
                        .errorCode(404)
                        .message(exception.getMessage())
                        .developerMessage("Record not found.")
                    .build(),
                HttpStatus.NOT_FOUND
        );
    }

}
