package org.kie.kogito.jobmanagement.mapper;

import org.kie.kogito.jobmanagement.dto.ApplicationDTO;
import org.kie.kogito.jobmanagement.entity.Application;
import org.kie.kogito.jobmanagement.entity.Job;
import org.kie.kogito.jobmanagement.service.JobServiceInterface;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.inject.Inject;

@Mapper(componentModel = "cdi")
public abstract class ApplicationMapper {

    @Inject
    JobServiceInterface jobService;

    public Application toApplicationEntity(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setId(applicationDTO.getId());
        application.setApplicantId(applicationDTO.getApplicantId());
        application.setStatus(applicationDTO.getStatus());
        Long jobId = applicationDTO.getJobId();
        Job job = jobService.GetJobById(jobId);
        application.setJob(job);
        return application;
    }

    @Mappings({
            @Mapping(target="jobId", source="application.job.id"),
    })
    public abstract ApplicationDTO toApplicationDTO(Application application);
}
