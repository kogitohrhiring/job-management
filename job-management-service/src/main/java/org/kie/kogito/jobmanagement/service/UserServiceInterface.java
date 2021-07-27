package org.kie.kogito.jobmanagement.service;

import org.kie.kogito.jobmanagement.entity.Education;
import org.kie.kogito.jobmanagement.entity.Experience;
import org.kie.kogito.jobmanagement.entity.User;

public interface UserServiceInterface {
    User GetUserById(Long userId);

    void CreateUser(User user);

    void UpdateUser(Long userId, User user);

    void UpdateEducation(Long userId, Education education, Long educationId);

    void CreateEducation(Long userId, Education education);

    void UpdateExperience(Long userId, Experience experience, Long experienceId);

    void CreateExperience(Long userId, Experience experience);

    void DeleteUser(Long userId);

    void DeleteExperience(Long experienceId);

    void DeleteEducation(Long educationId);
}
