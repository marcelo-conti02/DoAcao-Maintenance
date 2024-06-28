package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_user")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "isadmin")
    private boolean isadmin;

    public User(int id, String login, String password, boolean isadmin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isadmin = isadmin;
    }

    public User() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return this.isadmin;
    }

    public void setIsAdmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public User withId(int id) {
        this.id = id;
        return this;
    }

    public User withLogin(String login) {
        this.login = login;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User withIsAdmin(boolean isadmin) {
        this.isadmin = isadmin;
        return this;
    }
}