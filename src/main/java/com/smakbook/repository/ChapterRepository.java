package com.smakbook.repository;

import com.smakbook.dto.chapter.ChapterTitleResponse;
import com.smakbook.model.Chapter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterRepository
 * @since 21/11/2024 — 00.30
 **/
@Repository
public interface ChapterRepository extends BaseRepository<Chapter, Integer> {
    @Query("SELECT new com.smakbook.dto.chapter.ChapterTitleResponse(c.id, c.number, c.title) FROM Chapter c WHERE c.volume.id = :volumeId")
    List<ChapterTitleResponse> findChapterTitlesByVolumeId(@Param("volumeId") Integer volumeId);
}
