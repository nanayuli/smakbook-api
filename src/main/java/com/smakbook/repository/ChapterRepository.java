package com.smakbook.repository;

import com.smakbook.model.Chapter;
import org.springframework.stereotype.Repository;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterRepository
 * @since 21/11/2024 — 00.30
 **/
@Repository
public interface ChapterRepository extends BaseRepository<Chapter, Integer> {
}
