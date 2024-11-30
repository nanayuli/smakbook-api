package com.smakbook.dto.volume;

import com.smakbook.dto.chapter.ChapterTitleResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class VolumeResponse
 * @since 30/11/2024 — 01.34
 **/
@Getter
@Setter
public class VolumeResponse {
    private Integer id;
    private Integer number;
    private String title;
    private List<ChapterTitleResponse> chapters;
}
