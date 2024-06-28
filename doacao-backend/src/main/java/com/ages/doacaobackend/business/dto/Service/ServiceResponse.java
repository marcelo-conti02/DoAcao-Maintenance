package com.ages.doacaobackend.business.dto.Service;

public class ServiceResponse {

    private int id_service;

    private String name;

    private int limitService;

    public ServiceResponse (int id_service, String name, int limitService) {
        this.id_service = id_service;
        this.name = name;
        this.limitService = limitService;
    }

    public ServiceResponse () {

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

    public ServiceResponse withId_Service(int id_service) {
        this.id_service = id_service;
        return this;
    }

    public ServiceResponse withName(String name) {
        this.name = name;
        return this;
    }

    public ServiceResponse withLimitService(int limitService) {
        this.limitService = limitService;
        return this;
    }
}