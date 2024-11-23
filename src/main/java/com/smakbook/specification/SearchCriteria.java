package com.smakbook.specification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class SearchCriteria
 * @since 20/11/2024 — 22.48
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchCriteria {
    private String key; // Field name
    private Object value; // Value to search/filter
    private SearchOperation operation; // Operation type
}
