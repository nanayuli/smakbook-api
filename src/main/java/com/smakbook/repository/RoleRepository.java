package com.smakbook.repository;

import com.smakbook.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class RoleRepository
 * @since 21/11/2024 — 00.32
 **/
@Repository
public interface RoleRepository extends BaseRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
