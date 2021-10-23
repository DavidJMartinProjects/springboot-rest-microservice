package com.store.cart.exception;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import lombok.extern.slf4j.Slf4j;

/**
 * @author david
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)    
    ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException exception, HttpServletRequest request) {
        log.info("Handling exception: EntityNotFound.");
        ErrorResponse errorResponse =  ErrorResponse.builder()
            .errorCode(404)
            .message(exception.getMessage())
            .developerMessage("Record not found.")
            .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InternalServerError.class)    
    ResponseEntity<ErrorResponse> handleInternalServerError(InternalServerError exception, HttpServletRequest request) {
        log.info("Handling exception: InternalServerError.");
        ErrorResponse errorResponse =  ErrorResponse.builder()
            .errorCode(500)
            .message(exception.getMessage())
            .developerMessage("Encountered internal server error.")
            .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
