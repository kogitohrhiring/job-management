package org.kie.kogito.jobmanagement.controller;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.kie.kogito.jobmanagement.dto.ApplicantDTO;
import org.kie.kogito.jobmanagement.dto.EducationDTO;
import org.kie.kogito.jobmanagement.dto.ExperienceDTO;
import org.kie.kogito.jobmanagement.mapper.ApplicantMapper;
import org.kie.kogito.jobmanagement.mapper.EducationMapper;
import org.kie.kogito.jobmanagement.mapper.ExperienceMapper;
import org.kie.kogito.jobmanagement.service.ApplicantServiceInterface;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/applicants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient
public class ApplicantController implements ApplicantControllerInterface {

    @Inject
    ApplicantServiceInterface applicantService;

    @Inject
    ApplicantMapper applicantMapper;

    @Inject
    EducationMapper educationMapper;

    @Inject
    ExperienceMapper experienceMapper;

    @Override
    public ApplicantDTO FindByApplicantId(Long applicantId) {
        return applicantMapper.toApplicantDTO(applicantService.GetApplicantById(applicantId));
    }

    @Override
    public void CreateOrUpdateApplicant(ApplicantDTO applicantDTO) {
        applicantService.CreateOrUpdateApplicant(applicantMapper.toApplicantEntity(applicantDTO));
    }

    @Override
    public void CreateOrUpdateEducation(Long applicantId, EducationDTO educationDTO) {
        applicantService.CreateOrUpdateEducation(applicantId, educationMapper.toEducationEntity(educationDTO));
    }

    @Override
    public void CreateOrUpdateExperience(Long applicantId, ExperienceDTO experienceDTO) {
        applicantService.CreateOrUpdateExperience(applicantId, experienceMapper.toExperienceEntity(experienceDTO));
    }

    @Override
    public void DeleteApplicant(Long applicantId) {
        applicantService.DeleteApplicant(applicantId);
    }

    @Override
    public void DeleteExperience(Long experienceId) {
        applicantService.DeleteExperience(experienceId);
    }

    @Override
    public void DeleteEducation(Long educationId) {
        applicantService.DeleteEducation(educationId);
    }
}
