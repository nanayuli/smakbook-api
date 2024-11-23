package com.smakbook.service;

import com.smakbook.model.ChapterComment;
import com.smakbook.repository.ChapterCommentRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class ChapterCommentServiceImpl
 * @since 23/11/2024 — 17.20
 **/
@Service
public class ChapterCommentServiceImpl extends BaseServiceImpl<ChapterComment, Integer> {
    public ChapterCommentServiceImpl(ChapterCommentRepository repository) {
        super(repository, ChapterComment.class);
    }
}
