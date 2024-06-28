package com.ages.doacaobackend.business.dto.ServiceOrder;

import java.util.List;


public class ServiceOrderRequest {
    private int idInstitution;

    private boolean isUrgent;

    private List<ServiceQuantityOrderRequest> services;

    private String description;

    public ServiceOrderRequest(int idInstitution, boolean isUrgent, List<ServiceQuantityOrderRequest> services,
                               String description) {
        this.idInstitution = idInstitution;
        this.isUrgent = isUrgent;
        this.services = services;
        this.description = description;
    }

    public ServiceOrderRequest() {}

    public int getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
    }

    public boolean isIsUrgent() {
        return this.isUrgent;
    }

    public boolean getIsUrgent() {
        return this.isUrgent;
    }

    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public List<ServiceQuantityOrderRequest> getServices() {
        return this.services;
    }

    public void setServices(List<ServiceQuantityOrderRequest> services) {
        this.services = services;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceOrderRequest withIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ServiceOrderRequest withIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
        return this;
    }

    public ServiceOrderRequest withServices(List<ServiceQuantityOrderRequest> services) {
        this.services = services;
        return this;
    }

    public ServiceOrderRequest withDescription(String description) {
        this.description = description;
        return this;
    }
}
