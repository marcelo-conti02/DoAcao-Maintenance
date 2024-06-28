package com.ages.doacaobackend.business.dto.ServiceOrder;

import com.ages.doacaobackend.business.dto.ProductOrder.ProductQuantityOrderResponse;
import com.ages.doacaobackend.business.entity.ServiceQuantityOrder;

import java.time.LocalDateTime;
import java.util.List;

public class ServiceOrderListResponse {

    private int idServiceOrder;

    private int idInstitution;

    private String institutionDescription;

    private String institutionName;

    private boolean isUrgent;

    private LocalDateTime createdTime;

    private LocalDateTime limitDate;

    private List<ServiceQuantityOrderResponse> services;

    public ServiceOrderListResponse(int idServiceOrder, int idInstitution, String institutionDescription, String institutionName, boolean isUrgent, LocalDateTime createdTime, LocalDateTime limitDate, List<ServiceQuantityOrderResponse> services) {
        this.idServiceOrder = idServiceOrder;
        this.idInstitution = idInstitution;
        this.institutionDescription = institutionDescription;
        this.institutionName = institutionName;
        this.isUrgent = isUrgent;
        this.createdTime = createdTime;
        this.limitDate = limitDate;
        this.services = services;
    }

    public ServiceOrderListResponse(int idServiceOrder, int idInstitution, boolean isUrgent, LocalDateTime createdTime, LocalDateTime limitDate, List<ServiceQuantityOrderResponse> services) {
        this.idServiceOrder = idServiceOrder;
        this.idInstitution = idInstitution;
        this.isUrgent = isUrgent;
        this.createdTime = createdTime;
        this.limitDate = limitDate;
        this.services = services;
    }

    public ServiceOrderListResponse() {}

    public int getIdServiceOrder() {
        return this.idServiceOrder;
    }

    public void setIdServiceOrder(int idServiceOrder) {
        this.idServiceOrder = idServiceOrder;
    }

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

    public List<ServiceQuantityOrderResponse> getServices() {
        return this.services;
    }

    public void setServices(List<ServiceQuantityOrderResponse> services) {
        this.services = services;
    }

    public ServiceOrderListResponse withIdServiceOrder(int idServiceOrder) {
        this.idServiceOrder = idServiceOrder;
        return this;
    }

    public ServiceOrderListResponse withIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ServiceOrderListResponse withIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
        return this;
    }

    public ServiceOrderListResponse withCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ServiceOrderListResponse withLimitDate(LocalDateTime limitDate) {
        this.limitDate = limitDate;
        return this;
    }

    public ServiceOrderListResponse withServices(List<ServiceQuantityOrderResponse> services) {
        this.services = services;
        return this;
    }

    public ServiceOrderListResponse withInstitutionName(String institutionName) {
        this.institutionName = institutionName;
        return this;
    }

    public ServiceOrderListResponse withInstitutionDescription(String institutionDescription) {
        this.institutionDescription = institutionDescription;
        return this;
    }

    public String getInstitutionDescription() {
        return institutionDescription;
    }

    public void setInstitutionDescription(String institutionDescription) {
        this.institutionDescription = institutionDescription;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public ServiceOrderListResponse withItens(List<ServiceQuantityOrderResponse> services) {
        this.services = services;
        return this;
    }
}
