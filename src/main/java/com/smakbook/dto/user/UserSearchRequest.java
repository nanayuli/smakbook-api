package com.smakbook.dto.user;

import com.smakbook.dto.PageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserSearchRequest
 * @since 29/11/2024 — 12.40
 **/
@Getter
@Setter
public class UserSearchRequest extends PageRequest {
    private String username;
    private String role;
}
