package com.smakbook.dto.chapter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterResponse
 * @since 30/11/2024 — 12.02
 **/
@Getter
@Setter
public class ChapterResponse {
    private Integer id;
    private Integer novelId;
    private String novelTitle;
    private String volumeTitle;
    private Integer volumeNumber;
    private Integer number;
    private String title;
    private String content;
    private Boolean isPublished;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
