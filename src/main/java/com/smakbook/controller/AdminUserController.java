package com.smakbook.controller;

import com.smakbook.dto.user.UserSaveAsAdminRequest;
import com.smakbook.dto.user.UserResponse;
import com.smakbook.mapper.UserMapper;
import com.smakbook.model.User;
import com.smakbook.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AdminUserController
 * @since 29/11/2024 — 02.42
 **/
@RestController
@CrossOrigin(origins = {"${application.cors.origin}"})
@RequiredArgsConstructor
@RequestMapping(value = "/api/admin/users")
public class AdminUserController {
    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @PostMapping("/")
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserSaveAsAdminRequest request) {
        User user = userService.createUserAsAdmin(request);
        return new ResponseEntity<>(userMapper.toResponse(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Integer id, @Valid @RequestBody UserSaveAsAdminRequest request) {
        User user = userService.updateUserAsAdmin(id, request);
        return new ResponseEntity<>(userMapper.toResponse(user), HttpStatus.OK);
    }
}
