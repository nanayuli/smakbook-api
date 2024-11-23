package com.smakbook.repository;

import com.smakbook.model.Tag;
import org.springframework.stereotype.Repository;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class TagRepository
 * @since 21/11/2024 — 00.27
 **/
@Repository
public interface TagRepository extends BaseRepository<Tag, Integer> {
}
