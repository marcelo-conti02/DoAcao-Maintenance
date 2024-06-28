package com.ages.doacaobackend.business.dto.ServiceSolicitation;

public class ServiceSolicitationEditStatusRequest {
    private int id;

    private String status;

    public ServiceSolicitationEditStatusRequest() {}

    public ServiceSolicitationEditStatusRequest(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public ServiceSolicitationEditStatusRequest withId(int id) {
        this.id = id;
        return this;
    }

    public ServiceSolicitationEditStatusRequest withStatus(String status) {
        this.status = status;
        return this;
    }
}
