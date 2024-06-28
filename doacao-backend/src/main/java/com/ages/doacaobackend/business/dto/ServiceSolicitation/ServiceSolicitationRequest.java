package com.ages.doacaobackend.business.dto.ServiceSolicitation;

public class ServiceSolicitationRequest {
    private int idInstitution;

    private String service;

    public ServiceSolicitationRequest() {}

    public ServiceSolicitationRequest(int idInstitution, String service) {
        this.idInstitution = idInstitution;
        this.service = service;
    }

    public int getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }
    
    public ServiceSolicitationRequest withIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ServiceSolicitationRequest withService(String service) {
        this.service = service;
        return this;
    }

}
