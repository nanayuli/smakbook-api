package com.smakbook.service;

import com.smakbook.dto.chapter.ChapterTitleResponse;
import com.smakbook.model.Chapter;
import com.smakbook.repository.ChapterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterServiceImpl
 * @since 23/11/2024 — 17.21
 **/
@Service
public class ChapterServiceImpl extends BaseServiceImpl<Chapter, Integer> {
    private final ChapterRepository repository;

    public ChapterServiceImpl(ChapterRepository repository) {
        super(repository, Chapter.class);
        this.repository = repository;
    }

    public List<ChapterTitleResponse> getByVolumeId(Integer volumeId) {
        return repository.findChapterTitlesByVolumeId(volumeId);
    }
}
