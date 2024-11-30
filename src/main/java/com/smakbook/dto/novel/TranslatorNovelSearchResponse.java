package com.smakbook.dto.novel;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class TranslatorNovelSearchResponse
 * @since 30/11/2024 — 00.10
 **/
@Getter
@Setter
public class TranslatorNovelSearchResponse {
    private Integer id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
