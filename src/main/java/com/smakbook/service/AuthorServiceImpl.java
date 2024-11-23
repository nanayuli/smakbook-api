package com.smakbook.service;

import com.smakbook.model.Author;
import com.smakbook.repository.AuthorRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AuthorServiceImpl
 * @since 23/11/2024 — 17.18
 **/
@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author, Integer> {
    public AuthorServiceImpl(AuthorRepository repository) {
        super(repository, Author.class);
    }
}
