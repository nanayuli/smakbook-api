package com.smakbook.dto.novel;

import com.smakbook.dto.user.UserShortResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AdminNovelSearchResponse
 * @since 29/11/2024 — 23.45
 **/
@Getter
@Setter
public class AdminNovelSearchResponse {
    private Integer id;
    private String title;
    private UserShortResponse translator;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
