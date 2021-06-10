package org.kie.kogito.jobmanagement.controller;


import org.kie.kogito.jobmanagement.dto.ApplicationDTO;
import org.kie.kogito.jobmanagement.entity.Application;
import org.kie.kogito.jobmanagement.mapper.ApplicationMapper;
import org.kie.kogito.jobmanagement.service.impl.ApplicationService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/jobs")
public class ApplicationController implements ApplicationControllerInterface {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    @Inject
    ApplicationService applicationService;

    @Inject
    ApplicationMapper applicationMapper;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Response applyJob(ApplicationDTO applicationDTO) {
        Application savedApplication = applicationService.applyJob(applicationMapper.toApplicationEntity(applicationDTO));
        ApplicationDTO savedApplicationDTO = applicationMapper.toApplicationDTO(savedApplication);
        return Response.ok(savedApplicationDTO).build();
    }
}
