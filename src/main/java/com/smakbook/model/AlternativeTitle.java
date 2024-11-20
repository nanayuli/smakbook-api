package com.smakbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class AlternativeTitle
 * @since 20/11/2024 — 19.10
 **/
@Entity
@Table(name = "alternative_title")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class AlternativeTitle extends BaseEntity {
    private String title;
}
