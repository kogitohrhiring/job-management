package org.kie.kogito.jobmanagement.entity;

import org.kie.kogito.jobmanagement.enums.ApplicationStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Application {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name = "applicant_id")
    private Long applicantId;

    @Column(name = "applied_date")
    private Date appliedDate;

    @Column(name = "status")
    private ApplicationStatus status;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public Application() {
    }

    public Application(Long id, Job job, Long applicantId, Date appliedDate, ApplicationStatus status) {
        this.id = id;
        this.job = job;
        this.applicantId = applicantId;
        this.appliedDate = appliedDate;
        this.status = status;
    }

    // ------------------------------------------------------------------------
    // getter/setters
    // ------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
        Application that = (Application) o;
        return Objects.equals(id, that.id) && Objects.equals(job, that.job) && Objects.equals(applicantId, that.applicantId) && Objects.equals(appliedDate, that.appliedDate) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, job, applicantId, appliedDate, status);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", job=" + job +
                ", applicantId=" + applicantId +
                ", appliedDate=" + appliedDate +
                ", status=" + status +
                '}';
    }
}
