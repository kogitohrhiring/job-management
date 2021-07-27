package org.kie.kogito.jobmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
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
    private String userSummary;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "skillSet",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name = "skillId", referencedColumnName = "Id"))
    private Set<Skill> skillSet;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private List<Education> educationSet;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private List<Experience> experienceSet;

    public User() {
    }
}
