package org.kie.kogito.jobmanagement.service.impl;

import io.quarkus.panache.common.Parameters;
import org.kie.kogito.jobmanagement.dao.Application;
import org.kie.kogito.jobmanagement.dao.Job;
import org.kie.kogito.jobmanagement.repository.ApplicationRepository;
import org.kie.kogito.jobmanagement.repository.JobRepository;
import org.kie.kogito.jobmanagement.service.JobManagementServiceInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class JobManagementService implements JobManagementServiceInterface {

    @Inject
    JobRepository jobRepository;

    @Inject
    ApplicationRepository applicationRepository;

    @Override
    public Job GetJobById(Long jobId) {
        return jobRepository.findById(jobId);
    }

    @Override
    public Collection<Job> GetAllJobs() {
        return jobRepository.listAll();
    }

    @Override
    @Transactional
    public void CreateJob(Job job) {
        jobRepository.persist(job);
    }

    @Override
    public void applyJob(final Application application) {
        Long exists = applicationRepository.find("applicantId = :applicantId and jobId = :jobId",
                Parameters.with("applicantId", application.getApplicantId()).and("jobId", application.getJobId()))
                .count();
        if (exists > 0) {
            throw new IllegalArgumentException("Job has already been applied by applicant");
        }
        applicationRepository.persist(application);
    }
}
