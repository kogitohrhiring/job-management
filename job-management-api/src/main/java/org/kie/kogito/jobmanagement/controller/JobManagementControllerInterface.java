package org.kie.kogito.jobmanagement.controller;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.kie.kogito.jobmanagement.dto.JobDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

@Path("/jobs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface JobManagementControllerInterface {

    @GET
    @Path("/job/{jobId}")
    JobDTO FindByJobId(@PathParam("jobId") Long jobId);

    @GET
    Collection<JobDTO> FindAllJobs();

    @POST
    void CreateJob(JobDTO jobDTO);
}
