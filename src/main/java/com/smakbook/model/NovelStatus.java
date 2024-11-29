package com.smakbook.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class NovelStatus
 * @since 20/11/2024 — 19.47
 **/
@Getter
@AllArgsConstructor
public enum NovelStatus {
    SOON("скоро"),
    ONGOING("видається"),
    PAUSED("призупинено"),
    COMPLETED("завершено");

    @JsonValue
    private final String dbValue;

    @JsonCreator
    public static NovelStatus fromDbValue(String dbValue) {
        for (NovelStatus status : NovelStatus.values()) {
            if (status.dbValue.equals(dbValue)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbValue);
    }
}
