package com.smakbook.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class PageRequest
 * @since 21/11/2024 — 03.04
 **/
@Getter
@Setter
public class PageRequest {
    private int page = 0;
    private int pageSize = 10;
    private String sortBy = "id";
    private String sortDirection = "ASC";
}
