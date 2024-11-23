package com.smakbook.repository;

import com.smakbook.model.Volume;
import org.springframework.stereotype.Repository;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class VolumeRepository
 * @since 21/11/2024 — 00.33
 **/
@Repository
public interface VolumeRepository extends BaseRepository<Volume, Integer> {
}
