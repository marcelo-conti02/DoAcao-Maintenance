package com.ages.doacaobackend.business.entity;

import com.ages.doacaobackend.business.enums.GeneralStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_details_order")
public class ServiceDetailsOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_service_details_order")
    private int idServiceDetailsOrder;

    @OneToOne(targetEntity = Institution.class)
    @JoinColumn(name = "id_institution")
    private Institution idInstitution;

    @Column(name = "is_urgent")
    private boolean isUrgent;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "limit_date")
    private LocalDateTime limitDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private GeneralStatus status;

    @Column(name = "description")
    private String description;

    public ServiceDetailsOrder(int idServiceDetailsOrder, Institution idInstitution, boolean isUrgent, LocalDateTime createdTime, 
            LocalDateTime limitDate, GeneralStatus status, String description) {

        this.idServiceDetailsOrder = idServiceDetailsOrder;
        this.idInstitution = idInstitution;
        this.isUrgent = isUrgent;
        this.createdTime = createdTime;
        this.limitDate = limitDate;
        this.status = status;
        this.description = description;
    }

    public ServiceDetailsOrder() {}


    public int getIdServiceDetailsOrder() {
        return this.idServiceDetailsOrder;
    }

    public void setIdServiceDetailsOrder(int idServiceDetailsOrder) {
        this.idServiceDetailsOrder = idServiceDetailsOrder;
    }

    public Institution getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
    }

    public boolean getIsUrgent() {
        return this.isUrgent;
    }

    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLimitDate() {
        return this.limitDate;
    }

    public void setLimitDate(LocalDateTime limitDate) {
        this.limitDate = limitDate;
    }

    public GeneralStatus getStatus() {
        return this.status;
    }

    public void setStatus(GeneralStatus status) {
        this.status = status;
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

    public ServiceDetailsOrder withIdServiceDetailsOrder(int idServiceDetailsOrder) {
        this.idServiceDetailsOrder = idServiceDetailsOrder;
        return this;
    }

    public ServiceDetailsOrder withIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ServiceDetailsOrder withIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
        return this;
    }

    public ServiceDetailsOrder withCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ServiceDetailsOrder withLimitDate(LocalDateTime limitDate) {
        this.limitDate = limitDate;
        return this;
    }

    public ServiceDetailsOrder withStatus(GeneralStatus status) {
        this.status = status;
        return this;
    }

    public ServiceDetailsOrder withDescription(String description) {
        this.description = description;
        return this;
    }
}
