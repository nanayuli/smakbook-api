package com.smakbook.exception;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class BadRequestException
 * @since 29/11/2024 — 13.05
 **/
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
