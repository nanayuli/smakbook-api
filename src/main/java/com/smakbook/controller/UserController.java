package com.smakbook.controller;

import com.smakbook.dto.user.UserSaveRequest;
import com.smakbook.dto.user.UserResponse;
import com.smakbook.mapper.UserMapper;
import com.smakbook.model.User;
import com.smakbook.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserController
 * @since 29/11/2024 — 02.41
 **/
@RestController
@CrossOrigin(origins = {"${application.cors.origin}"})
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UserController {
    private final UserServiceImpl service;
    private final UserMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Integer id) {
        User user = service.getById(id);
        return new ResponseEntity<>(mapper.toResponse(user), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<UserResponse> update(@PathVariable Integer id, @Valid @RequestBody UserSaveRequest request) {
        User user = service.updateOwnProfile(id, request);
        return new ResponseEntity<>(mapper.toResponse(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
