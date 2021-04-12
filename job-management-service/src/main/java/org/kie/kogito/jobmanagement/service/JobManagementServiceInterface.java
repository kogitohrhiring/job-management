package org.kie.kogito.jobmanagement.service;

import org.kie.kogito.jobmanagement.dto.Job;

import java.util.Collection;
import java.util.List;

public interface JobManagementServiceInterface {

    Job GetJobById(Long jobId);

    Collection<Job> GetAllJobs();

    void CreateJob(Job job);
}
