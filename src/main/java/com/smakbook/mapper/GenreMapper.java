package com.smakbook.mapper;

import com.smakbook.dto.genre.GenreResponse;
import com.smakbook.model.Genre;
import org.springframework.stereotype.Component;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class GenreMapper
 * @since 30/11/2024 — 01.49
 **/
@Component
public class GenreMapper {
    public GenreResponse toResponse(Genre genre) {
        GenreResponse response = new GenreResponse();
        response.setId(genre.getId());
        response.setName(genre.getName());
        return response;
    }
}
