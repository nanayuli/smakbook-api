package com.smakbook.service;

import com.smakbook.model.Volume;
import com.smakbook.repository.VolumeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class VolumeServiceImpl
 * @since 23/11/2024 — 17.26
 **/
@Service
public class VolumeServiceImpl extends BaseServiceImpl<Volume, Integer> {
    private final VolumeRepository repository;

    public VolumeServiceImpl(VolumeRepository repository) {
        super(repository, Volume.class);
        this.repository = repository;
    }

    public List<Volume> getByNovelId(Integer id) {
        return repository.findByNovelId(id);
    }
}
