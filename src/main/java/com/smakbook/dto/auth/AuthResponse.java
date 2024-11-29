package com.smakbook.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AuthResponse
 * @since 29/11/2024 — 00.15
 **/
@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {
    private String token; //access jwt token
    private Integer id;
    private String username;
    private String role;
}
