package org.kie.kogito.jobmanagement.service.impl;

import org.kie.kogito.jobmanagement.entity.Application;
import org.kie.kogito.jobmanagement.entity.Job;
import org.kie.kogito.jobmanagement.repository.ApplicationRepository;
import org.kie.kogito.jobmanagement.repository.JobRepository;
import org.kie.kogito.jobmanagement.service.JobServiceInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.Collection;

@ApplicationScoped
public class JobService implements JobServiceInterface {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    @Inject
    JobRepository jobRepository;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Job GetJobById(Long jobId) {
        Job job = jobRepository.findById(jobId);
        if (job == null) {
            throw new NotFoundException("Job not found");
        }
        return job;
    }

    @Override
    public Collection<Job> GetAllJobs() {
        return jobRepository.listAll();
    }

    @Override
    @Transactional
    public void CreateJob(Job job) {
        job.setId(null);
        jobRepository.persist(job);
    }
}
