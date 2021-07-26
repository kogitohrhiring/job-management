package org.kie.kogito.jobmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Experience {
    @Id
    @GeneratedValue
    private Long Id;
    @NotNull
    private String company;
    private String role;
    private String startDate;
    private String endDate;
}

