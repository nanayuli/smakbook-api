package com.smakbook.dto.novel;

import com.smakbook.dto.PageRequest;
import com.smakbook.model.TranslationStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ReaderNovelSearchRequest
 * @since 21/11/2024 — 03.06
 **/
@Getter
@Setter
public class ReaderNovelSearchRequest extends PageRequest {
    private String title;
    private List<Integer> genreIds;
    private List<Integer> tagIds;
    private String country;
    private TranslationStatus translationStatus;
}
