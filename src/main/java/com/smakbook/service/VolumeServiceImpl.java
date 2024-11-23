package com.smakbook.service;

import com.smakbook.model.Volume;
import com.smakbook.repository.VolumeRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class VolumeServiceImpl
 * @since 23/11/2024 — 17.26
 **/
@Service
public class VolumeServiceImpl extends BaseServiceImpl<Volume, Integer> {
    public VolumeServiceImpl(VolumeRepository repository) {
        super(repository, Volume.class);
    }
}
