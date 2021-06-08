package org.kie.kogito.jobmanagement.controller;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.kie.kogito.jobmanagement.dao.ApplicationDTO;
import org.kie.kogito.jobmanagement.dao.JobDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

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

    @POST
    @Path("/apply")
    Response applyJob(ApplicationDTO applicationDTO);
}
