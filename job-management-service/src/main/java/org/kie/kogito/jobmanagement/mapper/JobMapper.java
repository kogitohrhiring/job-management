package org.kie.kogito.jobmanagement.mapper;

import org.kie.kogito.jobmanagement.dao.Application;
import org.kie.kogito.jobmanagement.dao.ApplicationDTO;
import org.kie.kogito.jobmanagement.dao.Job;
import org.kie.kogito.jobmanagement.dao.JobDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "cdi")
public interface JobMapper {

    JobDTO toJobDTO(Job job);

    Collection<JobDTO> toJobDTOs(Collection<Job> jobs);

    Job toJobEntity(JobDTO jobDTO);

    Application toApplicationEntity(ApplicationDTO applicationDTO);
}
