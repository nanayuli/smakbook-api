package com.smakbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class Role
 * @since 20/11/2024 — 17.56
 **/
@Entity
@Table(name = "role", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class Role extends BaseEntity {
    private String name;
}
