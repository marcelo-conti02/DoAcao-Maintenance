package com.ages.doacaobackend.business.dto.ServiceOrder;

public class ServiceQuantityOrderRequest {
    private int idService;

    private int quantitySolicited;

    private String description;

    public ServiceQuantityOrderRequest(int idService, int quantitySolicited, String description) {
        this.idService = idService;
        this.quantitySolicited = quantitySolicited;
        this.description = description;
    }

    public ServiceQuantityOrderRequest() {}

    public int getIdService() {
        return this.idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getQuantitySolicited() {
        return this.quantitySolicited;
    }

    public void setQuantitySolicited(int quantitySolicited) {
        this.quantitySolicited = quantitySolicited;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceQuantityOrderRequest withIdService(int idService) {
        this.idService = idService;
        return this;
    }

    public ServiceQuantityOrderRequest withQuantitySolicited(int quantitySolicited) {
        this.quantitySolicited = quantitySolicited;
        return this;
    }

    public ServiceQuantityOrderRequest withDescription(String description) {
        this.description = description;
        return this;
    }
}
