package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name="service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_service")
    private int id_service;

    @Column(name="name")
    private String name;

    @Column(name="limit_service")
    private int limitService;

    public Service (int id_service, String name, int limit_service) {
        this.id_service = id_service;
        this.name = name;
        this.limitService = limit_service;
    }

    public Service () {

    }

    public int getId_Service() {
        return this.id_service;
    }

    public void setId_Service(int id_service) {
        this.id_service = id_service;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimitService() {
        return limitService;
    }

    public void setLimitService(int limit_service) {
        this.limitService = limit_service;
    }

    public Service withId_Service(int id_service) {
        this.id_service = id_service;
        return this;
    }

    public Service withName(String name) {
        this.name = name;
        return this;
    }

    public Service withLimitService(int limit_service) {
        this.limitService = limit_service;
        return this;
    }
}