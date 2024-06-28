package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "administrator")
public class Administrator {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_adm")
    private int id_adm;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User id_user;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;


    public Administrator(int id_adm, User id_user, String name, String email) {
        this.id_adm = id_adm;
        this.name = name;
        this.email = email;
        this.id_user = id_user;
    }

    public Administrator() {

    }

    public int getId_adm() {
        return this.id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public User getId_user() {
        return this.id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Administrator withId_adm(int id_adm) {
        this.id_adm = id_adm;
        return this;
    }

    public Administrator withName(String name) {
        this.name = name;
        return this;
    }

    public Administrator withEmail(String email) {
        this.email = email;
        return this;
    }
}
