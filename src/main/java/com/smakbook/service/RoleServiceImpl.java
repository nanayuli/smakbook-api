package com.smakbook.service;

import com.smakbook.model.Role;
import com.smakbook.repository.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class RoleServiceImpl
 * @since 23/11/2024 — 17.23
 **/
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> {
    public RoleServiceImpl(RoleRepository repository) {
        super(repository, Role.class);
    }
}
