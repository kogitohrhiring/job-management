package org.kie.kogito.jobmanagement.dto;

import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
public class UserDTO {
    private Long Id;
    private String name;
    private String role;
    private String email;
    private Long phone;
    private int age;
    private int yoe;
    private String location;
    private String ctc;
    private String userSummary;
    private Set<SkillDTO> skillSet;
    private List<EducationDTO> educationSet;
//    private List<ExperienceDTO> experienceSet;
}
