package org.kie.kogito.jobmanagement.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Experience extends PanacheEntity {
    private String company;
    private String role;
    private String startDate;
    private String endDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Applicant applicant;
}

