package org.kie.kogito.jobmanagement.mapper;

import org.kie.kogito.jobmanagement.dto.EducationDTO;
import org.kie.kogito.jobmanagement.entity.Education;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface EducationMapper {
    EducationDTO toEducationDTO(Education education);

    Education toEducationEntity(EducationDTO educationDTO);
}
