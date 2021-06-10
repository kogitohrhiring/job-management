package org.kie.kogito.jobmanagement.service.impl;

import org.kie.kogito.jobmanagement.entity.Application;
import org.kie.kogito.jobmanagement.repository.ApplicationRepository;
import org.kie.kogito.jobmanagement.service.ApplicationServiceInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class ApplicationService implements ApplicationServiceInterface {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    @Inject
    ApplicationRepository applicationRepository;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    @Transactional
    public Application applyJob(final Application application) {
        application.setId(null);

        // Check if applicant has already applied for the Job
        boolean exists = applicationRepository.isApplicationExists(application.getApplicantId(), application.getJob().getId());

        // If already applied then send proper message
        if (exists) {
            throw new IllegalArgumentException("Job has already been applied by applicant");
        }

        // If not applied then persist application.
        applicationRepository.persist(application);

        return application;

    }
}
