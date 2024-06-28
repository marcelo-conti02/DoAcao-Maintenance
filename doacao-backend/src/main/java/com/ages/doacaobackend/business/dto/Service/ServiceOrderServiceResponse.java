package com.ages.doacaobackend.business.dto.Service;

public class ServiceOrderServiceResponse {

    private int idService;

    private String name;

    private int quantity;

    public ServiceOrderServiceResponse(int idService, String name, int quantity) {
        this.idService = idService;
        this.name = name;
        this.quantity = quantity;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
