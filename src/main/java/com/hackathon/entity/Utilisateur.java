//package com.hackathon.entity;
//
//
//
//import org.hibernate.validator.constraints.UniqueElements;
//
//import javax.persistence.*;
//import java.util.Collection;
//
//@Entity
//public class Utilisateur{
//
//    @Id
//    @Column(name = "id_utilisateur")
//    private long id;
//
//    @Column(name="username_utilisateur")
//    private String username;
//
//    @Column(name="name_utilisateur")
//    private String name;
//
//    @Column(name="password_utilisateur")
//    private String password;
//
//
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "utilisateur_jeu",
//            joinColumns = { @JoinColumn(name = "id_utilisateur") },
//            inverseJoinColumns = { @JoinColumn(name = "id_jeux") }
//    )
//    private Collection<Jeu> jeux;
//
//
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "utilisateur_progres",
//            joinColumns = { @JoinColumn(name = "id_utilisateur") },
//            inverseJoinColumns = { @JoinColumn(name = "id_progres") }
//    )
//    private Collection<Progres> progres;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//    public Collection<Jeu> getJeux() {
//        return jeux;
//    }
//
//    public void setJeux(Collection<Jeu> jeux) {
//        this.jeux = jeux;
//    }
//
//    public Collection<Progres> getProgres() {
//        return progres;
//    }
//
//    public void setProgres(Collection<Progres> progres) {
//        this.progres = progres;
//    }
//
//
//
//}
