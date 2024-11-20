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
 * @class Tag
 * @since 20/11/2024 — 17.41
 **/
@Entity
@Table(name = "tag")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class Tag extends BaseEntity {
    private String name;
}
