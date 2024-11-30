package com.smakbook.controller;

import com.smakbook.dto.genre.GenreResponse;
import com.smakbook.mapper.GenreMapper;
import com.smakbook.model.Genre;
import com.smakbook.service.GenreServiceImpl;
import lombok.RequiredArgsConstructor;
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
 * @class GenreController
 * @since 30/11/2024 — 13.46
 **/
@RestController
@CrossOrigin(origins = {"${application.cors.origin}"})
@RequiredArgsConstructor
@RequestMapping(value = "/api/genres")
public class GenreController {
    private final GenreServiceImpl service;
    private final GenreMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponse> get(@PathVariable Integer id) {
        Genre genre = service.getById(id);
        return new ResponseEntity<>(mapper.toResponse(genre), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<GenreResponse>> getAll() {
        List<GenreResponse> genreResponses = service.getAll().stream().map(mapper::toResponse).toList();
        return new ResponseEntity<>(genreResponses, HttpStatus.OK);
    }
}
