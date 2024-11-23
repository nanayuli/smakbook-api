package com.smakbook.service;

import com.smakbook.model.Tag;
import com.smakbook.repository.TagRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class TagServiceImpl
 * @since 23/11/2024 — 17.24
 **/
@Service
public class TagServiceImpl extends BaseServiceImpl<Tag, Integer> {
    public TagServiceImpl(TagRepository repository) {
        super(repository, Tag.class);
    }
}
