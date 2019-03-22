package com.hackathon.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="status_project")
    private String status;

    @Column(name="description_project")
    private String description;

    @Column(name="moreInfo_project")
    private String moreInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_companies_project", referencedColumnName = "id")
    private Company company;

    public Project(String title, String status, String description, String moreInfo, Company company) {
        this.title = title;
        this.status = status;
        this.description = description;
        this.moreInfo = moreInfo;
        this.company = company;
    }

    public Project() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    @JsonIgnore
    public Company getCompany() {
        return company;
    }
}
