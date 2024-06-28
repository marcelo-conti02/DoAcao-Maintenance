package com.ages.doacaobackend.business.dto.ServiceSolicitation;

import java.time.LocalDateTime;

import com.ages.doacaobackend.business.entity.ServiceSolicitation;
import com.ages.doacaobackend.business.enums.GeneralStatus;

public class ServiceSolicitationResponse {
    private int idServiceSolicitation;

    private int idInstitution;

    private LocalDateTime createdTime;

    private String service;

    private GeneralStatus status;

    public ServiceSolicitationResponse() {}

    public ServiceSolicitationResponse(int idServiceSolicitation, int idInstitution, LocalDateTime createdTime, String service, GeneralStatus status) {
        this.idServiceSolicitation = idServiceSolicitation;
        this.idInstitution = idInstitution;
        this.createdTime = createdTime;
        this.service = service;
        this.status = status;
    }

    public ServiceSolicitationResponse(ServiceSolicitation i) {
        this.idServiceSolicitation = i.getIdServiceSolicitation();
        this.idInstitution = i.getIdInstitution().getId_institution();
        this.createdTime = i.getCreatedTime();
        this.service = i.getService();
        this.status = i.getStatus();
    }


    public int getIdServiceSolicitation() {
        return this.idServiceSolicitation;
    }

    public void setIdServiceSolicitation(int idServiceSolicitation) {
        this.idServiceSolicitation = idServiceSolicitation;
    }

    public int getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
    }

    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public GeneralStatus getStatus() {
        return this.status;
    }

    public void setStatus(GeneralStatus status) {
        this.status = status;
    }

    public ServiceSolicitationResponse withIdServiceSolicitationResponse(int idServiceSolicitation) {
        this.idServiceSolicitation = idServiceSolicitation;
        return this;
    }

    public ServiceSolicitationResponse withIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ServiceSolicitationResponse withCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ServiceSolicitationResponse withService(String service) {
        this.service = service;
        return this;
    }

    public ServiceSolicitationResponse withStatus(GeneralStatus status) {
        this.status = status;
        return this;
    }
}
