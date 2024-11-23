package com.smakbook.service;

import com.smakbook.model.User;
import com.smakbook.repository.UserRepository;
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
    public UserServiceImpl(UserRepository repository) {
        super(repository, User.class);
    }
}
