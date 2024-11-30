package com.smakbook.controller;

import com.smakbook.dto.tag.TagResponse;
import com.smakbook.mapper.TagMapper;
import com.smakbook.model.Tag;
import com.smakbook.service.TagServiceImpl;
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
 * @class TagController
 * @since 30/11/2024 — 13.50
 **/
@RestController
@CrossOrigin(origins = {"${application.cors.origin}"})
@RequiredArgsConstructor
@RequestMapping(value = "/api/tags")
public class TagController {
    private final TagServiceImpl service;
    private final TagMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<TagResponse> get(@PathVariable Integer id) {
        Tag tag = service.getById(id);
        return new ResponseEntity<>(mapper.toResponse(tag), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TagResponse>> getAll() {
        List<TagResponse> tagResponses = service.getAll().stream().map(mapper::toResponse).toList();
        return new ResponseEntity<>(tagResponses, HttpStatus.OK);
    }
}