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
 * @class Genre
 * @since 20/11/2024 — 16.42
 **/
@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class Genre extends BaseEntity {
    private String name;
}
