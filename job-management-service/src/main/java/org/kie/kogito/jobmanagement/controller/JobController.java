package org.kie.kogito.jobmanagement.controller;

import org.kie.kogito.jobmanagement.dto.ApplicationDTO;
import org.kie.kogito.jobmanagement.dto.JobDTO;
import org.kie.kogito.jobmanagement.mapper.ApplicationMapper;
import org.kie.kogito.jobmanagement.mapper.JobMapper;
import org.kie.kogito.jobmanagement.service.JobServiceInterface;
import org.kie.kogito.jobmanagement.service.impl.ApplicationService;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/jobs")
public class JobController implements JobControllerInterface {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    @Inject
    JobServiceInterface jobService;

    @Inject
    JobMapper jobMapper;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public JobDTO FindByJobId(Long jobId) {
        return jobMapper.toJobDTO(jobService.GetJobById(jobId));
    }

    @Override
    public Collection<JobDTO> FindAllJobs() {
        return jobMapper.toJobDTOs(jobService.GetAllJobs());
    }

    @Override
    public void CreateJob(JobDTO jobDTO) {
        jobService.CreateJob(jobMapper.toJobEntity(jobDTO));
    }
}
