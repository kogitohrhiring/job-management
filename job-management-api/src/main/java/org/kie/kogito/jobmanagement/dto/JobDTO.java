package org.kie.kogito.jobmanagement.dto;

import java.util.Objects;

public class JobDTO {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Long id;

    private String name;

    private String location;

    private String category;

    private String jobSummary;

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
        JobDTO jobDTO = (JobDTO) o;
        return Objects.equals(id, jobDTO.id) && Objects.equals(name, jobDTO.name) && Objects.equals(location, jobDTO.location) && Objects.equals(category, jobDTO.category) && Objects.equals(jobSummary, jobDTO.jobSummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, category, jobSummary);
    }
}
