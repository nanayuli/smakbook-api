package com.smakbook.service;

import com.smakbook.dto.user.UserSaveAsAdminRequest;
import com.smakbook.dto.user.UserSaveRequest;
import com.smakbook.exception.UsernameAlreadyExistsException;
import com.smakbook.model.Role;
import com.smakbook.model.User;
import com.smakbook.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserServiceImpl
 * @since 23/11/2024 — 17.25
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleServiceImpl roleService;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, RoleServiceImpl roleService) {
        super(repository, User.class);
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public User registerUser(UserSaveRequest request) {
        if (repository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException("Username is already taken");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role role = roleService.getByName("READER");
        user.setRole(role);
        return super.save(user);
    }

    public User updateOwnProfile(Integer id, UserSaveRequest request) {
        User user = getById(id);
        if (!user.getUsername().equals(request.getUsername()) && repository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException("Username is already taken");
        }
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return super.save(user);
    }

    public User createUserAsAdmin(UserSaveAsAdminRequest request) {
        if (repository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException("Username is already taken");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role role = roleService.getByName(request.getRole());
        user.setRole(role);
        return super.save(user);
    }

    public User updateUserAsAdmin(Integer id, UserSaveAsAdminRequest request) {
        User user = getById(id);
        if (!user.getUsername().equals(request.getUsername()) && repository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException("Username is already taken");
        }
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role role = roleService.getByName(request.getRole());
        user.setRole(role);
        return super.save(user);
    }
}
