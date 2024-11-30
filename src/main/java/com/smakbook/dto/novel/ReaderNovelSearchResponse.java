package com.smakbook.dto.novel;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ReaderNovelSearchResponse
 * @since 29/11/2024 — 20.28
 **/
@Getter
@Setter
public class ReaderNovelSearchResponse {
    private Integer id;
    private String title;
    private String coverImagePath;
    private String country;
    private String translationStatus;
}
