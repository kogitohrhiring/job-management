package org.kie.kogito.jobmanagement.mapper;

import org.kie.kogito.jobmanagement.dto.SkillDTO;
import org.kie.kogito.jobmanagement.entity.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface SkillMapper {
    SkillDTO toSkillDTO(Skill skill);

    Skill toSkillEntity(SkillDTO skillDTO);
}
