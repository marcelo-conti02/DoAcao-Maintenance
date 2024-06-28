package com.ages.doacaobackend.business.dto.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ServiceRequest {

    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode estar em branco")
    private String name;

    @NotNull(message = "Limit_service não pode ser nulo")
    @NotBlank(message = "Limit_service não pode estar em branco")
    private int limitService;

    public ServiceRequest (String name, int limitService) {
        this.name = name;
        this.limitService = limitService;
    }

    public ServiceRequest () {

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

    public void setLimitService(int limitService) {
        this.limitService = limitService;
    }

    public ServiceRequest withName(String name) {
        this.name = name;
        return this;
    }

    public ServiceRequest withLimitService(int limitService) {
        this.limitService = limitService;
        return this;
    }
}