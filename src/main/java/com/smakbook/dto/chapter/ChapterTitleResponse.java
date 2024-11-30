package com.smakbook.dto.chapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterTitleResponse
 * @since 30/11/2024 — 01.38
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterTitleResponse {
    private Integer id;
    private Integer number;
    private String title;
}
