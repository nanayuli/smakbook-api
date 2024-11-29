package com.smakbook.controller;

import com.smakbook.dto.CustomPage;
import com.smakbook.dto.user.UserSaveAsAdminRequest;
import com.smakbook.dto.user.UserResponse;
import com.smakbook.dto.user.UserSearchRequest;
import com.smakbook.exception.BadRequestException;
import com.smakbook.mapper.UserMapper;
import com.smakbook.model.User;
import com.smakbook.service.UserServiceImpl;
import com.smakbook.specification.SearchCriteria;
import com.smakbook.specification.UserSpecificationBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

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

    @PostMapping("/search")
    public ResponseEntity<CustomPage<UserResponse>> searchUsers(@RequestBody UserSearchRequest userSearchRequest) {
        Sort.Direction direction;
        try {
            direction = Sort.Direction.fromString(userSearchRequest.getSortDirection());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid sort direction: " + userSearchRequest.getSortDirection());
        }
        Pageable pageable = PageRequest.of(userSearchRequest.getPage(), userSearchRequest.getPageSize(), direction, userSearchRequest.getSortBy());

        UserSpecificationBuilder builder = new UserSpecificationBuilder()
                .withUsername(userSearchRequest.getUsername())
                .withRole(userSearchRequest.getRole());
        List<SearchCriteria> criteriaList = builder.build();

        Page<User> userPage = userService.search(criteriaList, pageable);
        List<UserResponse> userResponses = userPage.getContent().stream().map(userMapper::toResponse).toList();
        CustomPage<UserResponse> responsePage = new CustomPage<>(
                userResponses,
                userPage.getNumber(),
                userPage.getSize(),
                userPage.getTotalElements(),
                userPage.getTotalPages(),
                userPage.isFirst(),
                userPage.isLast()
        );

        return new ResponseEntity<>(responsePage, HttpStatus.OK);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
