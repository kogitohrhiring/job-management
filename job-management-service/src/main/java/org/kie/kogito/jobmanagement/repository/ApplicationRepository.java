package org.kie.kogito.jobmanagement.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import org.kie.kogito.jobmanagement.entity.Application;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationRepository implements PanacheRepository<Application> {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public boolean isApplicationExists(Long applicantId, Long jobId) {
        long exists = find("applicant_id = :applicantId and job_id = :jobId",
                Parameters.with("applicantId", applicantId).and("jobId", jobId))
                .count();
        return exists > 0;
    }
}
