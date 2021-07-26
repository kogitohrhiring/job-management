package org.kie.kogito.jobmanagement.mapper;

import org.kie.kogito.jobmanagement.dto.UserDTO;
import org.kie.kogito.jobmanagement.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    UserDTO toUserDTO(User user);

    User toUserEntity(UserDTO userDTO);
}
