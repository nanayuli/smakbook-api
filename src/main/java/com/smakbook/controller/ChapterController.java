package com.smakbook.controller;

import com.smakbook.dto.chapter.ChapterResponse;
import com.smakbook.exception.DatabaseFetchException;
import com.smakbook.mapper.ChapterMapper;
import com.smakbook.model.Chapter;
import com.smakbook.model.Novel;
import com.smakbook.security.UserDetailsImpl;
import com.smakbook.service.ChapterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterController
 * @since 30/11/2024 — 11.59
 **/
@RestController
@CrossOrigin(origins = {"${application.cors.origin}"})
@RequiredArgsConstructor
@RequestMapping(value = "/api/chapters")
public class ChapterController {
    private final ChapterServiceImpl service;
    private final ChapterMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<ChapterResponse> get(@PathVariable Integer id, Authentication authentication) {
        Chapter chapter = service.getById(id);

        Integer currentUserId = null;
        boolean isAdmin = false;

        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetailsImpl currentUser) {
            currentUserId = currentUser.getId();
            isAdmin = currentUser.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
        }

        // Access control check
        Novel novel = chapter.getVolume().getNovel();

        boolean isChapterPublished = chapter.isPublished();
        boolean isNovelPublished = novel.isPublished();

        if (!isChapterPublished || !isNovelPublished) {
            // If the chapter or novel is unpublished, check if the user is authorized
            if (!isAdmin && (!novel.getTranslator().getId().equals(currentUserId))) {
                // Return 404 Not Found to hide the existence of the chapter
                throw new DatabaseFetchException("Could not find Chapter with id " + id);
            }
        }

        return new ResponseEntity<>(mapper.toResponse(chapter), HttpStatus.OK);
    }
}
