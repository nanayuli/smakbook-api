package com.smakbook.exception;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UsernameAlreadyExistsException
 * @since 29/11/2024 — 01.33
 **/
public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
