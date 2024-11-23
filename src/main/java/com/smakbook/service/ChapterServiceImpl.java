package com.smakbook.service;

import com.smakbook.model.Chapter;
import com.smakbook.repository.ChapterRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterServiceImpl
 * @since 23/11/2024 — 17.21
 **/
@Service
public class ChapterServiceImpl extends BaseServiceImpl<Chapter, Integer> {
    public ChapterServiceImpl(ChapterRepository repository) {
        super(repository, Chapter.class);
    }
}
