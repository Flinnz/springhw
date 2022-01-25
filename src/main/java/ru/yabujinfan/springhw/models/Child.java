package ru.yabujinfan.springhw.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "child")
@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "fullname")
    private String fullname;

    public Child(String fullname, int age) {
        this.fullname = fullname;
        this.age = age;
    }

    public Child() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Column(name = "age")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToMany(mappedBy = "children")
    private Set<Parent> parents = new HashSet<>();

    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }


    @ManyToOne
    @JoinColumn(name = "educational_institution_id")
    private EducationalInstitution educationalInstitution;

    public EducationalInstitution getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(EducationalInstitution educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }
}
