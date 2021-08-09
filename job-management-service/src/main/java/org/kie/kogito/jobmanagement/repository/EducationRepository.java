package org.kie.kogito.jobmanagement.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.kie.kogito.jobmanagement.entity.Education;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EducationRepository implements PanacheRepository<Education> {
}
