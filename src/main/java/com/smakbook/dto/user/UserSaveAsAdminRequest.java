package com.smakbook.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserSaveAsAdminRequest
 * @since 29/11/2024 — 10.34
 **/
@Getter
@Setter
public class UserSaveAsAdminRequest {
    @NotBlank
    @Size(min = 3, max = 64)
    private String username;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

    private String role;
}
