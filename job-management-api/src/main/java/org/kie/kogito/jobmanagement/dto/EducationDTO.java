package org.kie.kogito.jobmanagement.dto;

import lombok.Data;

@Data
public class EducationDTO {
    private Long Id;
    private String name;
    private String level;
    private String branch;
    private int year;
}
