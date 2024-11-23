package com.smakbook.service;

import com.smakbook.model.Novel;
import com.smakbook.repository.NovelRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class NovelServiceImpl
 * @since 23/11/2024 — 17.22
 **/
@Service
public class NovelServiceImpl extends BaseServiceImpl<Novel, Integer> {
    public NovelServiceImpl(NovelRepository repository) {
        super(repository, Novel.class);
    }
}
