package com.smakbook.specification;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class SearchOperation
 * @since 21/11/2024 — 00.38
 **/
public enum SearchOperation {
    EQUALITY,       // =
    NEGATION,       // !=
    GREATER_THAN,   // >
    LESS_THAN,      // <
    CONTAINS,       // CONTAINS '%value%'
    STARTS_WITH,    // CONTAINS 'value%'
    ENDS_WITH,      // CONTAINS '%value'
}
