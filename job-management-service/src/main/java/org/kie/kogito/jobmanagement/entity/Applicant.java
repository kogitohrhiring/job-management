package org.kie.kogito.jobmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String role;
    private String email;
    private Long phone;
    private int age;
    private int yoe;
    private String location;
    private String ctc;
    private String applicantSummary;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "skillSet",
            joinColumns = @JoinColumn(name = "applicantId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "skillId", referencedColumnName = "id"))
    private Set<Skill> skillSet;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.REMOVE)
    private List<Education> educationSet;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.REMOVE)
    private List<Experience> experienceSet;

    public Applicant() {
    }
}
