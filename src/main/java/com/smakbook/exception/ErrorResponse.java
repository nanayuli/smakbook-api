package com.smakbook.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ErrorResponse
 * @since 21/11/2024 — 01.24
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse {
    private int status;
    private String statusDescription;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime timestamp;
    private String path;
    private String message;
}
