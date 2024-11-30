package com.smakbook.dto.novel;

import com.smakbook.dto.genre.GenreResponse;
import com.smakbook.dto.tag.TagResponse;
import com.smakbook.dto.user.UserShortResponse;
import com.smakbook.dto.volume.VolumeResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class NovelDetailedResponse
 * @since 30/11/2024 — 00.31
 **/
@Getter
@Setter
public class NovelDetailedResponse {
    private Integer id;
    private String author;
    private UserShortResponse translator;
    private String coverImagePath;
    private String title;
    private List<String> alternativeTitles;
    private String description;
    private String country;
    private LocalDate releaseDate;
    private String novelStatus;
    private String translationStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<GenreResponse> genres;
    private List<TagResponse> tags;
    private List<VolumeResponse> volumes;
    private Boolean isPublished;
}
