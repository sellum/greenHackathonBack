package com.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="name_companies")
    private String name;

    @Column(name="contactInfo_companies")
    private String contactInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Project> projects;

    public Company(String name, String contactInfo, Category category) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.category = category;
    }

    public Company() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    @JsonIgnore
    public Category getCategory() {
        return category;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
