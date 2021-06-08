package org.kie.kogito.jobmanagement.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.kie.kogito.jobmanagement.dao.Application;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationRepository implements PanacheRepository<Application> {
}
