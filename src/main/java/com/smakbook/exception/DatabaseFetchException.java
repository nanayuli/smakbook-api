package com.smakbook.exception;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class DatabaseFetchException
 * @since 21/11/2024 — 01.20
 **/
public class DatabaseFetchException extends RuntimeException {
    public DatabaseFetchException(String message) {
        super(message);
    }
}
