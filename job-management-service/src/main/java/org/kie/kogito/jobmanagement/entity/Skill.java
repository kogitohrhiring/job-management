package org.kie.kogito.jobmanagement.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class Skill extends PanacheEntity {
//    @Id
//    @GeneratedValue
//    private Long Id;
    @NotNull
    private String name;
}

