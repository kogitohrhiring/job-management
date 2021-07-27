package org.kie.kogito.jobmanagement.service.impl;

import org.kie.kogito.jobmanagement.entity.Education;
import org.kie.kogito.jobmanagement.entity.Experience;
import org.kie.kogito.jobmanagement.entity.User;
import org.kie.kogito.jobmanagement.repository.EducationRepository;
import org.kie.kogito.jobmanagement.repository.ExperienceRepository;
import org.kie.kogito.jobmanagement.repository.UserRepository;
import org.kie.kogito.jobmanagement.service.UserServiceInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class UserService implements UserServiceInterface {
    @Inject
    UserRepository userRepository;

    @Inject
    ExperienceRepository experienceRepository;

    @Inject
    EducationRepository educationRepository;

    @Override
    public User GetUserById(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    @Override
    @Transactional
    public void CreateUser(User user) {
        user.setId(null);
        userRepository.persist(user);
    }

    @Override
    @Transactional
    public void UpdateUser(Long userId, User user) {
        user.setId(userId);
        userRepository.getEntityManager().merge(user);
    }

    @Override
    @Transactional
    public void UpdateEducation(Long userId, Education education, Long educationId) {
        Education existingEducation = educationRepository.findById(educationId);
        educationRepository.getEntityManager().merge(education);
        User existingUser = GetUserById(userId);
        existingEducation.setUser(existingUser);
        userRepository.getEntityManager().merge(existingUser);
    }

    @Override
    @Transactional
    public void CreateEducation(Long userId, Education education) {
        education.id = null;
        User existingUser = GetUserById(userId);
        if (existingUser == null) {
            throw new NotFoundException();
        }
        else {
            existingUser.getEducationSet().add(education);
        }
    }

    @Override
    @Transactional
    public void UpdateExperience(Long userId, Experience experience, Long experienceId) {
        Experience existingExperience = experienceRepository.findById(experienceId);
        experienceRepository.getEntityManager().merge(experience);
        User existingUser = GetUserById(userId);
        existingExperience.setUser(existingUser);
        userRepository.getEntityManager().merge(existingUser);
    }

    @Override
    @Transactional
    public void CreateExperience(Long userId, Experience experience) {
        experience.id = null;
        User existingUser = GetUserById(userId);
        if (existingUser == null) {
            throw new NotFoundException();
        }
        else {
            existingUser.getExperienceSet().add(experience);
        }
    }

    @Override
    @Transactional
    public void DeleteUser(Long userId) {
        User existingUser = GetUserById(userId);
        userRepository.delete(existingUser);
    }

    @Override
    @Transactional
    public void DeleteExperience(Long experienceId) {
        Experience existingExperience = experienceRepository.findById(experienceId);
        experienceRepository.delete(existingExperience);
    }

    @Override
    @Transactional
    public void DeleteEducation(Long educationId) {
        Education existingEducation = educationRepository.findById(educationId);
        educationRepository.delete(existingEducation);
    }
}
