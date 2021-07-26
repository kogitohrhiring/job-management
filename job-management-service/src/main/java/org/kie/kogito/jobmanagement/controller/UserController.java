package org.kie.kogito.jobmanagement.controller;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.kie.kogito.jobmanagement.dto.EducationDTO;
import org.kie.kogito.jobmanagement.dto.UserDTO;
import org.kie.kogito.jobmanagement.mapper.EducationMapper;
import org.kie.kogito.jobmanagement.mapper.UserMapper;
import org.kie.kogito.jobmanagement.service.UserServiceInterface;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient
public class UserController implements UserControllerInterface{

    @Inject
    UserServiceInterface userService;

    @Inject
    UserMapper userMapper;

    @Inject
    EducationMapper educationMapper;

    @Override
    public UserDTO FindByUserId(Long userId) {
        return userMapper.toUserDTO(userService.GetUserById(userId));
    }

    @Override
    public void CreateUser(UserDTO userDTO) {
        userService.CreateUser(userMapper.toUserEntity(userDTO));
    }

    @Override
    public void UpdateUser(Long userId, UserDTO userDTO) {
        userService.UpdateUser(userId, userMapper.toUserEntity(userDTO));
    }

    @Override
    public void UpdateEducation(Long userId, EducationDTO educationDTO, Long educationId) {
        userService.UpdateEducation(userId, educationMapper.toEducationEntity(educationDTO), educationId);
    }

    @Override
    public void CreateEducation(Long userId, EducationDTO educationDTO) {
        userService.CreateEducation(userId, educationMapper.toEducationEntity(educationDTO));
    }

    @Override
    public void DeleteUser(Long userId) {
        userService.DeleteUser(userId);
    }
}
