package org.kie.kogito.jobmanagement.service;

import org.kie.kogito.jobmanagement.entity.Education;
import org.kie.kogito.jobmanagement.entity.User;

import java.util.List;

public interface UserServiceInterface {
    User GetUserById(Long userId);

    void CreateUser(User user);

    void UpdateUser(Long userId, User user);

    void UpdateEducation(Long userId, Education education, Long educationId);

    void CreateEducation(Long userId, Education education);

    void DeleteUser(Long userId);
}
