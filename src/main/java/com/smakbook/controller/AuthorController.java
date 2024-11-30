package com.smakbook.controller;

import com.smakbook.dto.author.AuthorResponse;
import com.smakbook.mapper.AuthorMapper;
import com.smakbook.model.Author;
import com.smakbook.service.AuthorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AuthorController
 * @since 23/11/2024 — 17.27
 **/
@RestController
@CrossOrigin(origins = {"${application.cors.origin}"})
@RequestMapping("/api/authors")
@AllArgsConstructor
public class AuthorController {
    private final AuthorServiceImpl service;
    private final AuthorMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> get(@PathVariable Integer id) {
        Author author = service.getById(id);
        return new ResponseEntity<>(mapper.toResponse(author), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AuthorResponse>> getAll() {
        List<AuthorResponse> authorResponses = service.getAll().stream().map(mapper::toResponse).toList();
        return new ResponseEntity<>(authorResponses, HttpStatus.OK);
    }
}
