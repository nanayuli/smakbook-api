package com.smakbook.repository;

import com.smakbook.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserRepository
 * @since 21/11/2024 — 00.32
 **/
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
}
