package com.smakbook.mapper;

import com.smakbook.dto.chapter.ChapterResponse;
import com.smakbook.model.Chapter;
import com.smakbook.model.Novel;
import com.smakbook.model.Volume;
import org.springframework.stereotype.Component;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterMapper
 * @since 30/11/2024 — 01.51
 **/
@Component
public class ChapterMapper {
    public ChapterResponse toResponse(Chapter chapter) {
        ChapterResponse response = new ChapterResponse();
        response.setId(chapter.getId());

        Volume chapterVolume = chapter.getVolume();
        response.setVolumeTitle(chapterVolume.getTitle());
        response.setVolumeNumber(chapterVolume.getNumber());

        Novel chapterNovel = chapterVolume.getNovel();
        response.setNovelId(chapterNovel.getId());
        response.setNovelTitle(chapterNovel.getTitle());

        response.setTitle(chapter.getTitle());
        response.setNumber(chapter.getNumber());
        response.setContent(chapter.getContent());
        response.setIsPublished(chapter.isPublished());
        response.setCreatedAt(chapter.getCreatedAt());
        response.setUpdatedAt(chapter.getUpdatedAt());
        return response;
    }
}
