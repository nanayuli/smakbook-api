package com.smakbook.controller;

import com.smakbook.dto.user.UserSaveRequest;
import com.smakbook.dto.user.UserResponse;
import com.smakbook.dto.auth.AuthRequest;
import com.smakbook.dto.auth.AuthResponse;
import com.smakbook.mapper.UserMapper;
import com.smakbook.model.User;
import com.smakbook.security.AuthService;
import com.smakbook.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AuthController
 * @since 29/11/2024 — 00.21
 **/
@RestController
@CrossOrigin(origins = {"${application.cors.origin}"})
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth")
public class AuthController {
    private final AuthService service;
    private final UserMapper userMapper;
    private final UserServiceImpl userService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest request) {
        return new ResponseEntity<>(service.authenticate(request), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserSaveRequest request) {
        User user = userService.registerUser(request);
        return new ResponseEntity<>(userMapper.toResponse(user), HttpStatus.CREATED);
    }
}
