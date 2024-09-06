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
@Table(name = "product_details_order")
public class ProductDetailsOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_product_details_order")
    private int idProductDetailsOrder;

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

    @Column(name = "description", length = 1000)
    private String description;


    public ProductDetailsOrder(int idProductDetailsOrder, Institution idInstitution, boolean isUrgent, 
                   LocalDateTime createdTime, LocalDateTime limitDate, GeneralStatus status, String description) {
            
            this.idProductDetailsOrder = idProductDetailsOrder;
            this.idInstitution = idInstitution;
            this.isUrgent = isUrgent;
            this.createdTime = createdTime;
            this.limitDate = limitDate;
            this.status = status;
            this.description = description;
    }

    public ProductDetailsOrder() {}


    public int getIdProductDetailsOrder() {
        return this.idProductDetailsOrder;
    }

    public void setIdProductDetailsOrder(int idProductDetailsOrder) {
        this.idProductDetailsOrder = idProductDetailsOrder;
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

    public ProductDetailsOrder withIdProductDetailsOrder(int idProductDetailsOrder) {
        this.idProductDetailsOrder = idProductDetailsOrder;
        return this;
    }

    public ProductDetailsOrder withIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ProductDetailsOrder withIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
        return this;
    }

    public ProductDetailsOrder withCreatedDate(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ProductDetailsOrder withLimitDate(LocalDateTime limitDate) {
        this.limitDate = limitDate;
        return this;
    }

    public ProductDetailsOrder witStatus(GeneralStatus status) {
        this.status = status;
        return this;
    }

    public ProductDetailsOrder withDescription(String description) {
        this.description = description;
        return this;
    }
    
}
