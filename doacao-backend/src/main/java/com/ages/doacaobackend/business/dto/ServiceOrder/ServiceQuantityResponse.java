package com.ages.doacaobackend.business.dto.ServiceOrder;

public class ServiceQuantityResponse {
    
    private int idServiceQuantityOrder;

    private int idService;

    private int quantityServiceReceived;

    private int quantityServiceMissing;

    private int quantityServiceSolicited;

    public ServiceQuantityResponse(int idServiceQuantityOrder, int idService, int quantityServiceReceived, int quantityServiceMissing, int quantityServiceSolicited) {
        this.idServiceQuantityOrder = idServiceQuantityOrder;
        this.idService = idService;
        this.quantityServiceReceived = quantityServiceReceived;
        this.quantityServiceMissing = quantityServiceMissing;
        this.quantityServiceSolicited = quantityServiceSolicited;
    }

    public ServiceQuantityResponse() {}

    public int getIdServiceQuantityOrder() {
        return this.idServiceQuantityOrder;
    }

    public void setIdServiceQuantityOrder(int idServiceQuantityOrder) {
        this.idServiceQuantityOrder = idServiceQuantityOrder;
    }

    public int getIdService() {
        return this.idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getQuantityServiceReceived() {
        return this.quantityServiceReceived;
    }

    public void setQuantityServiceReceived(int quantityServiceReceived) {
        this.quantityServiceReceived = quantityServiceReceived;
    }

    public int getQuantityServiceMissing() {
        return this.quantityServiceMissing;
    }

    public void setQuantityServiceMissing(int quantityServiceMissing) {
        this.quantityServiceMissing = quantityServiceMissing;
    }

    public int getQuantityServiceSolicited() {
        return this.quantityServiceSolicited;
    }

    public void setQuantityServiceSolicited(int quantityServiceSolicited) {
        this.quantityServiceSolicited = quantityServiceSolicited;
    }

    public ServiceQuantityResponse withIdServiceOrderQuantityOrder(int idServiceQuantityOrder) {
        this.idServiceQuantityOrder = idServiceQuantityOrder;
        return this;
    }

    public ServiceQuantityResponse withIdService(int idService) {
        this.idService = idService;
        return this;
    }

    public ServiceQuantityResponse withQuantityServiceReceived(int quantityServiceReceived) {
        this.quantityServiceReceived = quantityServiceReceived;
        return this;
    }

    public ServiceQuantityResponse withQuantityServiceMissing(int quantityServiceMissing) {
        this.quantityServiceMissing = quantityServiceMissing;
        return this;
    }

    public ServiceQuantityResponse withQuantityServiceSolicited(int quantityServiceSolicited) {
        this.quantityServiceSolicited = quantityServiceSolicited;
        return this;
    }
}
