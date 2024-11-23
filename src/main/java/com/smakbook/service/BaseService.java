package com.smakbook.service;

import com.smakbook.model.BaseEntity;
import com.smakbook.specification.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class BaseService
 * @since 20/11/2024 — 22.45
 **/
public interface BaseService<T extends BaseEntity, ID extends Serializable> {
    T save(T entity);
    T getById(ID id);
    List<T> getAll();
    void deleteById(ID id);
    Page<T> search(List<SearchCriteria> criteriaList, Pageable pageable);
}
