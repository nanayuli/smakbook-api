package com.smakbook.specification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserSpecificationBuilder
 * @since 29/11/2024 — 12.51
 **/
public class UserSpecificationBuilder {
    private final List<SearchCriteria> criteriaList = new ArrayList<>();

    public UserSpecificationBuilder withUsername(String username) {
        if (username != null && !username.isEmpty()) {
            criteriaList.add(new SearchCriteria("username", username, SearchOperation.CONTAINS));
        }
        return this;
    }

    public UserSpecificationBuilder withRole(String role) {
        if (role != null && !role.isEmpty()) {
            criteriaList.add(new SearchCriteria("role.name", role, SearchOperation.EQUALITY));
        }
        return this;
    }

    public List<SearchCriteria> build() {
        return criteriaList;
    }
}
