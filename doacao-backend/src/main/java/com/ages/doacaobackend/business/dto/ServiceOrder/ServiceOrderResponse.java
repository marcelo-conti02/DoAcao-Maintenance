package com.ages.doacaobackend.business.dto.ServiceOrder;

import com.ages.doacaobackend.business.dto.Service.ServiceResponse;
import com.ages.doacaobackend.business.enums.GeneralStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ServiceOrderResponse {

    private int idServiceDetailsOrder;

    private List<ServiceResponse> services;

    private LocalDateTime createdTime;

    private LocalDateTime limitDate;

    private GeneralStatus status;


    public ServiceOrderResponse(int idServiceDetailsOrder, List<ServiceResponse> services, LocalDateTime createdTime, LocalDateTime limitDate, GeneralStatus status) {
        this.idServiceDetailsOrder = idServiceDetailsOrder;
        this.services = services;
        this.createdTime = createdTime;
        this.limitDate = limitDate;
        this.status = status;
    }

    public ServiceOrderResponse() {}


    public int getIdServiceDetailsOrder() {
        return this.idServiceDetailsOrder;
    }

    public void setIdServiceDetailsOrder(int idServiceDetailsOrder) {
        this.idServiceDetailsOrder = idServiceDetailsOrder;
    }

    public List<ServiceResponse> getServices() {
        return this.services;
    }

    public void setServices(List<ServiceResponse> services) {
        this.services = services;
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

    public ServiceOrderResponse withIdServiceDetailsOrder(int idServiceDetailsOrder) {
        this.idServiceDetailsOrder = idServiceDetailsOrder;
        return this;
    }

    public ServiceOrderResponse withServices(List<ServiceResponse> services) {
        this.services = services;
        return this;
    }

    public ServiceOrderResponse withCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ServiceOrderResponse withLimitDate(LocalDateTime limitDate) {
        this.limitDate = limitDate;
        return this;
    }

    public ServiceOrderResponse withIsActive(GeneralStatus status) {
        this.status = status;
        return this;
    }




}
