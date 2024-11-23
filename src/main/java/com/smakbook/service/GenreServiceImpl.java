package com.smakbook.service;

import com.smakbook.model.Genre;
import com.smakbook.repository.GenreRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class GenreServiceImpl
 * @since 23/11/2024 — 17.22
 **/
@Service
public class GenreServiceImpl extends BaseServiceImpl<Genre, Integer> {
    public GenreServiceImpl(GenreRepository repository) {
        super(repository, Genre.class);
    }
}
