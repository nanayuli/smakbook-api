package com.smakbook.repository;

import com.smakbook.model.Novel;
import org.springframework.stereotype.Repository;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class NovelRepository
 * @since 21/11/2024 — 00.28
 **/
@Repository
public interface NovelRepository extends BaseRepository<Novel, Integer> {
}
