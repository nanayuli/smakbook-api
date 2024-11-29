package com.smakbook.dto.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserResponse
 * @since 29/11/2024 — 02.44
 **/
@Getter
@Setter
public class UserResponse {
    private Integer id;
    private String username;
    private String role;
}
