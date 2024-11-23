package com.smakbook.repository;

import com.smakbook.model.Genre;
import org.springframework.stereotype.Repository;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class GenreRepository
 * @since 20/11/2024 — 22.44
 **/
@Repository
public interface GenreRepository extends BaseRepository<Genre, Integer> {
}
