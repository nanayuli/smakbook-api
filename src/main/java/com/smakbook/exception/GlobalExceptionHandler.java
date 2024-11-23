package com.smakbook.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class GlobalExceptionHandler
 * @since 21/11/2024 — 01.21
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DatabaseFetchException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseFetchException(DatabaseFetchException e, WebRequest request){
        log.error("Could not fetch data from the database", e);
        return getResponse(HttpStatus.NOT_FOUND, request, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e, WebRequest request) {
        log.error("An unexpected error occurred", e);
        return getResponse(HttpStatus.INTERNAL_SERVER_ERROR, request, "An unexpected error occurred");
    }

    private ResponseEntity<ErrorResponse> getResponse(HttpStatus status, WebRequest request, String message) {
        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        ErrorResponse errorMessage = new ErrorResponse(status.value(), status.getReasonPhrase(), ZonedDateTime.now(), path, message);
        return new ResponseEntity<>(errorMessage, status);
    }
}
