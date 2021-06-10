package org.kie.kogito.jobmanagement.service;

import org.kie.kogito.jobmanagement.entity.Application;
import org.kie.kogito.jobmanagement.entity.Job;

import java.util.Collection;

public interface JobServiceInterface {

    Job GetJobById(Long jobId);

    Collection<Job> GetAllJobs();

    void CreateJob(Job job);
}
