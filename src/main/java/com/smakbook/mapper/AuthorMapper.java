package com.smakbook.mapper;

import com.smakbook.dto.author.AuthorResponse;
import com.smakbook.model.Author;
import org.springframework.stereotype.Component;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AuthorMapper
 * @since 30/11/2024 — 13.55
 **/
@Component
public class AuthorMapper {
    public AuthorResponse toResponse(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        return response;
    }
}
