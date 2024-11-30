package com.smakbook.controller;

import com.smakbook.dto.CustomPage;
import com.smakbook.dto.novel.NovelDetailedResponse;
import com.smakbook.dto.novel.ReaderNovelSearchRequest;
import com.smakbook.dto.novel.ReaderNovelSearchResponse;
import com.smakbook.exception.BadRequestException;
import com.smakbook.exception.DatabaseFetchException;
import com.smakbook.mapper.NovelMapper;
import com.smakbook.model.Novel;
import com.smakbook.security.UserDetailsImpl;
import com.smakbook.service.NovelServiceImpl;
import com.smakbook.specification.NovelSpecificationBuilder;
import com.smakbook.specification.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class NovelController
 * @since 29/11/2024 — 20.26
 **/
@RestController
@CrossOrigin(origins = {"${application.cors.origin}"})
@RequiredArgsConstructor
@RequestMapping(value = "/api/novels")
public class NovelController {
    private final NovelServiceImpl service;
    private final NovelMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<NovelDetailedResponse> get(@PathVariable Integer id, Authentication authentication) {
        Novel novel = service.getById(id);

        if (!novel.isPublished()) {
            Integer currentUserId = null;
            boolean isAdmin = false;

            if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetailsImpl currentUser) {
                currentUserId = currentUser.getId();
                isAdmin = currentUser.getAuthorities().stream()
                        .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
            }

            if (!isAdmin && (!novel.getTranslator().getId().equals(currentUserId))) {
                // Return 404 Not Found to unauthorized users
                throw new DatabaseFetchException("Could not find Novel with id " + id);
            }
        }

        return new ResponseEntity<>(mapper.toDetailedResponse(novel), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<CustomPage<ReaderNovelSearchResponse>> search(@RequestBody ReaderNovelSearchRequest request) {
        Sort.Direction direction;
        try {
            direction = Sort.Direction.fromString(request.getSortDirection());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid sort direction: " + request.getSortDirection());
        }
        Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize(), direction, request.getSortBy());

        NovelSpecificationBuilder builder = new NovelSpecificationBuilder()
                .withTitle(request.getTitle())
                .withGenreIds(request.getGenreIds())
                .withTagIds(request.getTagIds())
                .withCountry(request.getCountry())
                .withTranslationStatus(request.getTranslationStatus())
                .withPublishedStatus(true);
        List<SearchCriteria> criteriaList = builder.build();

        Page<Novel> novelPage = service.search(criteriaList, pageable);
        List<ReaderNovelSearchResponse> novelResponses = novelPage.getContent().stream()
                .map(mapper::toReaderSearchResponse)
                .toList();
        CustomPage<ReaderNovelSearchResponse> responsePage = new CustomPage<>(
                novelResponses,
                novelPage.getNumber(),
                novelPage.getSize(),
                novelPage.getTotalElements(),
                novelPage.getTotalPages(),
                novelPage.isFirst(),
                novelPage.isLast()
        );

        return new ResponseEntity<>(responsePage, HttpStatus.OK);
    }
}
