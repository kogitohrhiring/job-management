package org.kie.kogito.jobmanagement.service.impl;

import org.kie.kogito.jobmanagement.entity.Applicant;
import org.kie.kogito.jobmanagement.entity.Education;
import org.kie.kogito.jobmanagement.entity.Experience;
import org.kie.kogito.jobmanagement.repository.ApplicantRepository;
import org.kie.kogito.jobmanagement.repository.EducationRepository;
import org.kie.kogito.jobmanagement.repository.ExperienceRepository;
import org.kie.kogito.jobmanagement.service.ApplicantServiceInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class ApplicantService implements ApplicantServiceInterface {
    @Inject
    ApplicantRepository applicantRepository;

    @Inject
    ExperienceRepository experienceRepository;

    @Inject
    EducationRepository educationRepository;

    @Override
    public Applicant GetApplicantById(Long applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId);
        if (applicant == null) {
            throw new NotFoundException("Applicant not found");
        }
        return applicant;
    }

    @Override
    @Transactional
    public void CreateOrUpdateApplicant(Applicant applicant) {
        if (applicant.getId() == null) {
            applicantRepository.persist(applicant);
            if (applicant.getEducationSet() != null) {
                for (Education education : applicant.getEducationSet()) {
                    education.setApplicant(applicant);
                    educationRepository.persist(education);
                }
            }
            if (applicant.getExperienceSet() != null) {

                for (Experience experience : applicant.getExperienceSet()) {
                    experience.setApplicant(applicant);
                    experienceRepository.persist(experience);

                }
            }
        }
        else {
            applicantRepository.getEntityManager().merge(applicant);
        }
    }

    @Override
    @Transactional
    public void CreateOrUpdateEducation(Long applicantId, Education education) {
        if (education.id == null) {
            Applicant existingApplicant = GetApplicantById(applicantId);
            if (existingApplicant == null) {
                throw new NotFoundException();
            }
            else {
                education.setApplicant(existingApplicant);
                educationRepository.persist(education);
            }
        }
        else {
            Education existingEducation = educationRepository.findById(education.id);
            educationRepository.getEntityManager().merge(education);
            Applicant existingApplicant = GetApplicantById(applicantId);
            existingEducation.setApplicant(existingApplicant);
            applicantRepository.getEntityManager().merge(existingApplicant);
        }
    }

    @Override
    @Transactional
    public void CreateOrUpdateExperience(Long applicantId, Experience experience) {
        if (experience.id == null) {
            Applicant existingApplicant = GetApplicantById(applicantId);
            if (existingApplicant == null) {
                throw new NotFoundException();
            }
            else {
                experience.setApplicant(existingApplicant);
                experienceRepository.persist(experience);
            }

        }
        else {
            Experience existingExperience = experienceRepository.findById(experience.id);
            experienceRepository.getEntityManager().merge(experience);
            Applicant existingApplicant = GetApplicantById(applicantId);
            existingExperience.setApplicant(existingApplicant);
            applicantRepository.getEntityManager().merge(existingApplicant);
        }
    }


    @Override
    @Transactional
    public void DeleteApplicant(Long applicantId) {
        Applicant existingApplicant = GetApplicantById(applicantId);
        applicantRepository.delete(existingApplicant);
    }

    @Override
    @Transactional
    public void DeleteExperience(Long experienceId) {
        Experience existingExperience = experienceRepository.findById(experienceId);
        experienceRepository.delete(existingExperience);
    }

    @Override
    @Transactional
    public void DeleteEducation(Long educationId) {
        Education existingEducation = educationRepository.findById(educationId);
        educationRepository.delete(existingEducation);
    }
}
