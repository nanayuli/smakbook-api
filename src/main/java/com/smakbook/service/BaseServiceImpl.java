package com.smakbook.service;

import com.smakbook.exception.DatabaseFetchException;
import com.smakbook.model.BaseEntity;
import com.smakbook.repository.BaseRepository;
import com.smakbook.specification.GenericSpecification;
import com.smakbook.specification.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class BaseServiceImpl
 * @since 21/11/2024 — 01.04
 **/
@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements BaseService<T, ID> {
    protected final BaseRepository<T, ID> repository;
    private final Class<T> entityClass;

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T getById(ID id) {
        return repository.findById(id).orElseThrow(() -> new DatabaseFetchException("Could not find " + entityClass.getSimpleName() + " with id " + id));
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<T> search(List<SearchCriteria> criteriaList, Pageable pageable) {
        Specification<T> specification = new GenericSpecification<>(criteriaList);
        return repository.findAll(specification, pageable);
    }
}
