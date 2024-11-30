package com.smakbook.mapper;

import com.smakbook.dto.user.UserResponse;
import com.smakbook.dto.user.UserShortResponse;
import com.smakbook.model.User;
import org.springframework.stereotype.Component;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserMapper
 * @since 29/11/2024 — 01.15
 **/
@Component
public class UserMapper {
    public UserResponse toResponse(User entity) {
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setRole(entity.getRole().getName());
        return response;
    }

    public UserShortResponse toShortResponse(User entity) {
        UserShortResponse response = new UserShortResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        return response;
    }
}
