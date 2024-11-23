package com.smakbook.service;

import com.smakbook.model.AlternativeTitle;
import com.smakbook.repository.AlternativeTitleRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AlternativeTitleServiceImpl
 * @since 21/11/2024 — 18.23
 **/
@Service
public class AlternativeTitleServiceImpl extends BaseServiceImpl<AlternativeTitle, Integer> {
    public AlternativeTitleServiceImpl(AlternativeTitleRepository repository) {
        super(repository, AlternativeTitle.class);
    }
}
