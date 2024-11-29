package com.smakbook.service;

import com.smakbook.exception.DatabaseFetchException;
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
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        super(repository, Role.class);
        this.repository = repository;
    }

    public Role getByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new DatabaseFetchException("Role with name " + name + " not found"));
    }
}
