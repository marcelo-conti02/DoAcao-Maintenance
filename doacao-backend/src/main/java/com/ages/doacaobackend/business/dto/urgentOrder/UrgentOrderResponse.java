package com.ages.doacaobackend.business.dto.urgentOrder;

import com.ages.doacaobackend.business.dto.Institution.InstitutionResponse;

import java.time.LocalDateTime;
import java.util.List;

public class UrgentOrderResponse {

    private int id;
    private List<UrgentOrderComponentMember> orderComponents;
    private boolean isService;
    private InstitutionResponse institution;
    private LocalDateTime createdAt;
    private String description;

    public UrgentOrderResponse() {
    }

    public UrgentOrderResponse(int id, List<UrgentOrderComponentMember> orderComponents, boolean isService, InstitutionResponse institution, LocalDateTime createdAt, String description) {
        this.id = id;
        this.orderComponents = orderComponents;
        this.isService = isService;
        this.institution = institution;
        this.createdAt = createdAt;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UrgentOrderComponentMember> getOrderComponents() {
        return orderComponents;
    }

    public void setOrderComponents(List<UrgentOrderComponentMember> orderComponents) {
        this.orderComponents = orderComponents;
    }

    public boolean isService() {
        return isService;
    }

    public void setService(boolean service) {
        isService = service;
    }

    public InstitutionResponse getInstitution() {
        return institution;
    }

    public void setInstitution(InstitutionResponse institution) {
        this.institution = institution;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
