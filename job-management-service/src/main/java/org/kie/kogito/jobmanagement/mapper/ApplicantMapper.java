package org.kie.kogito.jobmanagement.mapper;

import org.kie.kogito.jobmanagement.dto.ApplicantDTO;
import org.kie.kogito.jobmanagement.entity.Applicant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ApplicantMapper {
    ApplicantDTO toApplicantDTO(Applicant applicant);

    Applicant toApplicantEntity(ApplicantDTO applicantDTO);
}
