package com.hackathon.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private long id;

    @Column(name="name_categorie")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Company> companies;

    @JsonCreator
    public Category(@JsonProperty("name")  String name) {
        this.name = name;
    }

    public Category() {

    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
