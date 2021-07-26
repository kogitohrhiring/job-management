package org.kie.kogito.jobmanagement.controller;

import org.kie.kogito.jobmanagement.dto.EducationDTO;
import org.kie.kogito.jobmanagement.dto.UserDTO;

import javax.ws.rs.*;
import java.util.List;

public interface UserControllerInterface {
    @GET
    @Path("{userId}")
    UserDTO FindByUserId(@PathParam("userId") Long userId);

    @POST
    void CreateUser(UserDTO userDTO);

    @PUT
    @Path("{userId}")
    void UpdateUser(@PathParam("userId") Long userId, UserDTO userDTO);

    @PUT
    @Path("{userId}/education/{educationId}")
    void UpdateEducation(@PathParam("userId") Long userId, EducationDTO educationDTO, @PathParam("educationId") Long educationId);

    @POST
    @Path("{userId}/education")
    void CreateEducation(@PathParam("userId") Long userId, EducationDTO educationDTO);

    @DELETE
    @Path("{userId}")
    void DeleteUser(@PathParam("userId") Long userId);
}
