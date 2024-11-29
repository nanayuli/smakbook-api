package com.smakbook.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.util.List;

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

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException e, WebRequest request) {
        log.error("Attempted to log in with incorrect credentials", e);
        return getResponse(HttpStatus.UNAUTHORIZED, request, "Invalid username or password");
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAuthorizationDeniedException(AuthorizationDeniedException e, WebRequest request) {
        log.error("Authorization denied", e);
        return getResponse(HttpStatus.FORBIDDEN, request, "Access is denied due to insufficient permissions.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e, WebRequest request) {
        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        log.error("Validation failed: {}", errors);
        return getResponse(HttpStatus.BAD_REQUEST, request, errors.toString());
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException e, WebRequest request) {
        log.error("Attempted to register user with existing username", e);
        return getResponse(HttpStatus.CONFLICT, request, e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e, WebRequest request) {
        log.error("Data integrity violation occurred", e);
        String message = "A data integrity error occurred. Please ensure all inputs are correct and try again.";
        if (e.getCause() instanceof ConstraintViolationException) {
            message = "A database constraint was violated: " + e.getCause().getMessage();
        }
        return getResponse(HttpStatus.CONFLICT, request, message);
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
