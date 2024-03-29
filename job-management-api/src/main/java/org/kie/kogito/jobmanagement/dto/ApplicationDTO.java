package org.kie.kogito.jobmanagement.dto;

import org.kie.kogito.jobmanagement.enums.ApplicationStatus;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class ApplicationDTO {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Long id;

    @NotNull(message = "jobId may not be null")
    private Long jobId;

    @NotNull(message = "applicantId may not be null")
    private Long applicantId;

    private Date appliedDate;

    private ApplicationStatus status;

    // ------------------------------------------------------------------------
    // getter/setters
    // ------------------------------------------------------------------------


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

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationDTO that = (ApplicationDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(jobId, that.jobId) && Objects.equals(applicantId, that.applicantId) && Objects.equals(appliedDate, that.appliedDate) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobId, applicantId, appliedDate, status);
    }

    @Override
    public String toString() {
        return "ApplicationDTO{" +
                "id=" + id +
                ", jobId=" + jobId +
                ", applicantId=" + applicantId +
                ", appliedDate=" + appliedDate +
                ", status=" + status +
                '}';
    }
}
