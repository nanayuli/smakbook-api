package com.smakbook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class TranslationStatus
 * @since 20/11/2024 — 19.47
 **/
@Getter
@AllArgsConstructor
public enum TranslationStatus {
    SOON("скоро"),
    TRANSLATING("перекладається"),
    PAUSED("призупинено"),
    COMPLETED("завершено");

    private final String dbValue;
}
