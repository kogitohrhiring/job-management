package org.kie.kogito.jobmanagement.service;

import org.kie.kogito.jobmanagement.entity.Applicant;
import org.kie.kogito.jobmanagement.entity.Education;
import org.kie.kogito.jobmanagement.entity.Experience;

public interface ApplicantServiceInterface {
    Applicant GetApplicantById(Long applicantId);

    void CreateOrUpdateApplicant(Applicant applicant);

    void CreateOrUpdateEducation(Long applicantId, Education education);

    void CreateOrUpdateExperience(Long applicantId, Experience experience);

    void DeleteApplicant(Long applicantId);

    void DeleteExperience(Long applicantId);

    void DeleteEducation(Long educationId);
}
