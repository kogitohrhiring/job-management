package org.kie.kogito.jobmanagement.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

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

//    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true )
//    @JoinColumn(name = "userId", referencedColumnName = "Id"))
//    @OneToMany(targetEntity = Education.class, orphanRemoval = true, cascade= CascadeType.ALL)
//    @JoinColumn(name="user_id", referencedColumnName = "Id")
//    private List<Education> educationSet;

//    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
//    @JoinTable(name = "educationSet",
//            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "Id"),
//            inverseJoinColumns = @JoinColumn(name = "educationId", referencedColumnName = "Id"))
//    private List<Education> educationSet;
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="userId", referencedColumnName = "Id")
    private List<Education> educationSet;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "experienceSet",
//            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "Id"),
//            inverseJoinColumns = @JoinColumn(name = "experienceId", referencedColumnName = "Id"))
//    private List<Experience> experienceSet;

    public User() {
    }
}
