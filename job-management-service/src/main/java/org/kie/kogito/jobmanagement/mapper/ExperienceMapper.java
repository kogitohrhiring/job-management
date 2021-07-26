package org.kie.kogito.jobmanagement.mapper;

import org.kie.kogito.jobmanagement.dto.ExperienceDTO;
import org.kie.kogito.jobmanagement.entity.Experience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ExperienceMapper {
    ExperienceDTO toExperienceDTO(Experience experience);

    Experience toExperienceEntity(ExperienceDTO experienceDTO);
}
