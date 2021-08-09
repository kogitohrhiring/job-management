package org.kie.kogito.jobmanagement.dto;

import lombok.Data;

@Data
public class ExperienceDTO {
    private Long Id;
    private String company;
    private String role;
    private String startDate;
    private String endDate;
}
