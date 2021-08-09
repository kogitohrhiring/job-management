package org.kie.kogito.jobmanagement.controller;

import org.kie.kogito.jobmanagement.dto.ApplicantDTO;
import org.kie.kogito.jobmanagement.dto.EducationDTO;
import org.kie.kogito.jobmanagement.dto.ExperienceDTO;

import javax.ws.rs.*;

public interface ApplicantControllerInterface {
    @GET
    @Path("{applicantId}")
    ApplicantDTO FindByApplicantId(@PathParam("applicantId") Long applicantId);

    @POST
    void CreateOrUpdateApplicant(ApplicantDTO applicantDTO);

    @POST
    @Path("{applicantId}/experience")
    void CreateOrUpdateExperience(@PathParam("applicantId") Long applicantId, ExperienceDTO experienceDTO);

    @POST
    @Path("{applicantId}/education")
    void CreateOrUpdateEducation(@PathParam("applicantId") Long applicantId, EducationDTO educationDTO);

    @DELETE
    @Path("{applicantId}")
    void DeleteApplicant(@PathParam("applicantId") Long applicantId);

    @DELETE
    @Path("{applicantId}/experience/{experienceId}")
    void DeleteExperience(@PathParam("experienceId") Long experienceId);

    @DELETE
    @Path("{applicantId}/education/{educationId}")
    void DeleteEducation(@PathParam("educationId") Long educationId);
}
