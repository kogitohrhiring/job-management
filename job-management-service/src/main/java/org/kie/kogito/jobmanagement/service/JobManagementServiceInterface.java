package org.kie.kogito.jobmanagement.service;

import org.kie.kogito.jobmanagement.dao.Application;
import org.kie.kogito.jobmanagement.dao.ApplicationDTO;
import org.kie.kogito.jobmanagement.dao.Job;

import java.util.Collection;

public interface JobManagementServiceInterface {

    Job GetJobById(Long jobId);

    Collection<Job> GetAllJobs();

    void CreateJob(Job job);

    void applyJob(Application application);
}
