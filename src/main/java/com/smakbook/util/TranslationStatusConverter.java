package com.smakbook.util;

import com.smakbook.model.TranslationStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class TranslationStatusConverter
 * @since 29/11/2024 — 21.21
 **/
@Converter(autoApply = true)
public class TranslationStatusConverter implements AttributeConverter<TranslationStatus, String> {
    @Override
    public String convertToDatabaseColumn(TranslationStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getDbValue();
    }

    @Override
    public TranslationStatus convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return TranslationStatus.fromDbValue(dbData);
    }
}
