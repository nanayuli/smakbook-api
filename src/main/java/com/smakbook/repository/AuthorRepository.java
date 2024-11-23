package com.smakbook.repository;

import com.smakbook.model.Author;
import org.springframework.stereotype.Repository;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AuthorRepository
 * @since 21/11/2024 — 00.30
 **/
@Repository
public interface AuthorRepository extends BaseRepository<Author, Integer> {
}
