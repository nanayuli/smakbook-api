package com.smakbook.util;

import com.smakbook.model.NovelStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class NovelStatusConverter
 * @since 29/11/2024 — 21.17
 **/
@Converter(autoApply = true)
public class NovelStatusConverter implements AttributeConverter<NovelStatus, String> {
    @Override
    public String convertToDatabaseColumn(NovelStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getDbValue();
    }

    @Override
    public NovelStatus convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return NovelStatus.fromDbValue(dbData);
    }
}
