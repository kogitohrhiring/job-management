package org.kie.kogito.jobmanagement.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Education extends PanacheEntity {
    private String name;
    private String level;
    private String branch;
    private int year;
    @ManyToOne
    private Applicant applicant;
}

