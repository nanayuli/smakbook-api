package com.smakbook.repository;

import com.smakbook.model.ChapterComment;
import org.springframework.stereotype.Repository;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterCommentRepository
 * @since 21/11/2024 — 00.31
 **/
@Repository
public interface ChapterCommentRepository extends BaseRepository<ChapterComment, Integer> {
}
