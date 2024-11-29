package com.smakbook.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.smakbook.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UnauthorizedEntryPoint
 * @since 28/11/2024 — 23.58
 **/
@Component
@Slf4j
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        HttpStatus status = UNAUTHORIZED;
        log.error("Unauthorized error: {}", authException.getMessage());

        String path = request.getRequestURI();
        ErrorResponse errorResponse = new ErrorResponse(status.value(), status.getReasonPhrase(), ZonedDateTime.now(), path, authException.getMessage());

        response.setStatus(status.value());
        response.setContentType("application/json");
        objectMapper.writeValue(response.getOutputStream(), errorResponse);
    }
}
