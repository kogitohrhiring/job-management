package org.kie.kogito.jobmanagement.dao;

import org.kie.kogito.jobmanagement.enums.ApplicationStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long jobId;

    private Long applicantId;

    private Date appliedDate;

    private ApplicationStatus status;

    public Application() {
    }

    public Application(Long id, Long jobId, Long applicantId, Date appliedDate, ApplicationStatus status) {
        this.id = id;
        this.jobId = jobId;
        this.applicantId = applicantId;
        this.appliedDate = appliedDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(id, that.id) && Objects.equals(jobId, that.jobId) && Objects.equals(applicantId, that.applicantId) && Objects.equals(appliedDate, that.appliedDate) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobId, applicantId, appliedDate, status);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", jobId=" + jobId +
                ", applicantId=" + applicantId +
                ", appliedDate=" + appliedDate +
                ", status=" + status +
                '}';
    }
}
