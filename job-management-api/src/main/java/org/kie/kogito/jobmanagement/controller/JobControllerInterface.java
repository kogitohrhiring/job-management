package org.kie.kogito.jobmanagement.controller;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.kie.kogito.jobmanagement.dto.ApplicationDTO;
import org.kie.kogito.jobmanagement.dto.JobDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/jobs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface JobControllerInterface {

    @GET
    @Path("/job/{jobId}")
    JobDTO FindByJobId(@PathParam("jobId") Long jobId);

    @GET
    Collection<JobDTO> FindAllJobs();

    @POST
    void CreateJob(JobDTO jobDTO);
}
