package org.kie.kogito.jobmanagement.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Job {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String location;

    private String category;

    private String jobSummary;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public Job(){}

    public Job(Long id, String name){
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJobSummary() {
        return jobSummary;
    }

    public void setJobSummary(String jobSummary) {
        this.jobSummary = jobSummary;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id) && Objects.equals(name, job.name) && Objects.equals(location, job.location) && Objects.equals(category, job.category) && Objects.equals(jobSummary, job.jobSummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, category, jobSummary);
    }
}
