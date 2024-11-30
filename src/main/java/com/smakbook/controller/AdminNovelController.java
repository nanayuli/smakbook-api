package com.smakbook.controller;

import com.smakbook.dto.CustomPage;
import com.smakbook.dto.novel.AdminNovelSearchRequest;
import com.smakbook.dto.novel.AdminNovelSearchResponse;
import com.smakbook.exception.BadRequestException;
import com.smakbook.mapper.NovelMapper;
import com.smakbook.model.Novel;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AdminNovelController
 * @since 29/11/2024 — 23.56
 **/
@RestController
@CrossOrigin(origins = {"${application.cors.origin}"})
@RequiredArgsConstructor
@RequestMapping(value = "/api/admin/novels")
public class AdminNovelController {
    private final NovelServiceImpl novelService;
    private final NovelMapper novelMapper;

    @PostMapping("/search")
    public ResponseEntity<CustomPage<AdminNovelSearchResponse>> search(@RequestBody AdminNovelSearchRequest request) {
        Sort.Direction direction;
        try {
            direction = Sort.Direction.fromString(request.getSortDirection());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid sort direction: " + request.getSortDirection());
        }
        Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize(), direction, request.getSortBy());

        NovelSpecificationBuilder builder = new NovelSpecificationBuilder()
                .withTitle(request.getTitle())
                .withPublishedStatus(request.getPublishedStatus())
                .withTranslatorId(request.getTranslatorId());
        List<SearchCriteria> criteriaList = builder.build();

        Page<Novel> novelPage = novelService.search(criteriaList, pageable);
        List<AdminNovelSearchResponse> novelResponses = novelPage.getContent().stream()
                .map(novelMapper::toAdminSearchResponse)
                .toList();
        CustomPage<AdminNovelSearchResponse> responsePage = new CustomPage<>(
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
