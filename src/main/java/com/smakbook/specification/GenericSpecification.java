package com.smakbook.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class GenericSpecification
 * @since 21/11/2024 — 00.47
 **/
public class GenericSpecification<T> implements Specification<T> {
    private final List<SearchCriteria> criteriaList;

    public GenericSpecification(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Predicate toPredicate(@NonNull Root<T> root, CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : criteriaList) {
            Object value = criteria.getValue();
            String key = criteria.getKey();

            String[] keys = key.split("\\.");
            Path<Object> path = root.get(keys[0]);

            for (int i = 1; i < keys.length; i++) {
                path = path.get(keys[i]);
            }

            Class<?> fieldType = path.getJavaType();

            if (value == null) {
                throw new IllegalArgumentException("Value for key " + key + " cannot be null");
            }

            switch (criteria.getOperation()) {
                case EQUALITY:
                    predicates.add(criteriaBuilder.equal(path, value));
                    break;
                case NEGATION:
                    predicates.add(criteriaBuilder.notEqual(path, value));
                    break;
                case GREATER_THAN:
                case LESS_THAN:
                    if (Comparable.class.isAssignableFrom(fieldType)) {
                        Expression<? extends Comparable> expression = path.as((Class<? extends Comparable>) fieldType);
                        Comparable comparableValue = (Comparable) value;
                        if (criteria.getOperation() == SearchOperation.GREATER_THAN) {
                            predicates.add(criteriaBuilder.greaterThan(expression, comparableValue));
                        } else {
                            predicates.add(criteriaBuilder.lessThan(expression, comparableValue));
                        }
                    } else {
                        throw new IllegalArgumentException("Field " + key + " is not comparable for " + criteria.getOperation() + " operation");
                    }
                    break;
                case CONTAINS:
                case STARTS_WITH:
                case ENDS_WITH:
                    if (fieldType.equals(String.class)) {
                        String searchValue = value.toString().toLowerCase();
                        String pattern = switch (criteria.getOperation()) {
                            case CONTAINS -> "%" + searchValue + "%";
                            case STARTS_WITH -> searchValue + "%";
                            case ENDS_WITH -> "%" + searchValue;
                            default ->
                                    throw new UnsupportedOperationException("Operation " + criteria.getOperation() + " is not supported");
                        };
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(path.as(String.class)), pattern));
                    } else {
                        throw new IllegalArgumentException("Field " + key + " is not of type String for " + criteria.getOperation() + " operation");
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Operation " + criteria.getOperation() + " is not supported");
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
