package com.smakbook.mapper;

import com.smakbook.dto.tag.TagResponse;
import com.smakbook.model.Tag;
import org.springframework.stereotype.Component;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class TagMapper
 * @since 30/11/2024 — 01.50
 **/
@Component
public class TagMapper {
    public TagResponse toResponse(Tag tag) {
        TagResponse response = new TagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());
        return response;
    }
}
