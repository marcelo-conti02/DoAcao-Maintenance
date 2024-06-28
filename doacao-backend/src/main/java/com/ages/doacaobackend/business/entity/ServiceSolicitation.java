package com.ages.doacaobackend.business.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ages.doacaobackend.business.enums.GeneralStatus;
@Entity
@Table(name = "service_solicitation")
public class ServiceSolicitation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_service_solicitation")
    private int idServiceSolicitation;

    @OneToOne(targetEntity = Institution.class)
    @JoinColumn(name = "id_institution")
    private Institution idInstitution;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "service")
    private String service;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private GeneralStatus status;

    public ServiceSolicitation() {}

    public ServiceSolicitation(int idServiceSolicitation, Institution idInstitution, LocalDateTime createdTime, String service, GeneralStatus status) {
        this.idServiceSolicitation = idServiceSolicitation;
        this.idInstitution = idInstitution;
        this.createdTime = createdTime;
        this.service = service;
        this.status = status;
    }


    public int getIdServiceSolicitation() {
        return this.idServiceSolicitation;
    }

    public void setIdServiceSolicitation(int idServiceSolicitation) {
        this.idServiceSolicitation = idServiceSolicitation;
    }

    public Institution getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
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

    public ServiceSolicitation withIdServiceSolicitation(int idServiceSolicitation) {
        this.idServiceSolicitation = idServiceSolicitation;
        return this;
    }

    public ServiceSolicitation withIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ServiceSolicitation withCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ServiceSolicitation withService(String service) {
        this.service = service;
        return this;
    }

    public ServiceSolicitation withStatus(GeneralStatus status) {
        this.status = status;
        return this;
    }    
}
