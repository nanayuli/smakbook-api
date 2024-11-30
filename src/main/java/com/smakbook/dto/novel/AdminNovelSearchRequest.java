package com.smakbook.dto.novel;

import com.smakbook.dto.PageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AdminNovelSearchRequest
 * @since 29/11/2024 — 23.44
 **/
@Getter
@Setter
public class AdminNovelSearchRequest extends PageRequest {
    private Integer translatorId;
    private String title;
    private Boolean publishedStatus;
}
