package org.kie.kogito.jobmanagement.service.impl;

import org.kie.kogito.jobmanagement.dto.Job;
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
}
