package com.smakbook.mapper;

import com.smakbook.dto.volume.VolumeResponse;
import com.smakbook.model.Volume;
import com.smakbook.service.ChapterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class VolumeMapper
 * @since 30/11/2024 — 01.50
 **/
@Component
@RequiredArgsConstructor
public class VolumeMapper {
    private final ChapterServiceImpl chapterService;

    public VolumeResponse toResponse(Volume volume) {
        VolumeResponse response = new VolumeResponse();
        response.setId(volume.getId());
        response.setNumber(volume.getNumber());
        response.setTitle(volume.getTitle());
        response.setChapters(chapterService.getByVolumeId(volume.getId()));
        return response;
    }
}
