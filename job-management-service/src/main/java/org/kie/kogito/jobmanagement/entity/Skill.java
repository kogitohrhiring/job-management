package org.kie.kogito.jobmanagement.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class Skill extends PanacheEntity {
    @NotNull
    private String name;
}

