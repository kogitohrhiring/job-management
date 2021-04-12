package org.kie.kogito.jobmanagement.mapper;

import org.kie.kogito.jobmanagement.dto.Job;
import org.kie.kogito.jobmanagement.dto.JobDTO;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface JobMapper {

    JobDTO toJobDTO(Job job);

    Collection<JobDTO> toJobDTOs(Collection<Job> jobs);

    Job toJobEntity(JobDTO jobDTO);
}
