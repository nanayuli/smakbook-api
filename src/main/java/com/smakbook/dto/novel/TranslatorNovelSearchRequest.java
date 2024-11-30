package com.smakbook.dto.novel;

import com.smakbook.dto.PageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class TranslatorNovelSearchRequest
 * @since 29/11/2024 — 23.42
 **/
@Getter
@Setter
public class TranslatorNovelSearchRequest extends PageRequest {
    private String title;
    private Boolean publishedStatus;
}
