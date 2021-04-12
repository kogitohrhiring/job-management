package org.kie.kogito.jobmanagement.controller;

import org.kie.kogito.jobmanagement.dto.JobDTO;
import org.kie.kogito.jobmanagement.mapper.JobMapper;
import org.kie.kogito.jobmanagement.service.JobManagementServiceInterface;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.Collection;

@Path("/jobs")
public class JobManagementController implements JobManagementControllerInterface {

    @Inject
    JobManagementServiceInterface jobManagementService;

    @Inject
    JobMapper jobMapper;

    @Override
    public JobDTO FindByJobId(Long jobId) {
        return jobMapper.toJobDTO(jobManagementService.GetJobById(jobId));
    }

    @Override
    public Collection<JobDTO> FindAllJobs() {
        return jobMapper.toJobDTOs(jobManagementService.GetAllJobs());
    }

    @Override
    public void CreateJob(JobDTO jobDTO) {
        jobManagementService.CreateJob(jobMapper.toJobEntity(jobDTO));
    }
}
