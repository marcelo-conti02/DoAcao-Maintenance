package com.ages.doacaobackend.business.dto.ServiceOrder;

import com.ages.doacaobackend.business.entity.Service;
import com.ages.doacaobackend.business.entity.ServiceDetailsOrder;
import com.ages.doacaobackend.business.entity.ServiceQuantityOrder;

public class ServiceQuantityOrderResponse {
    private int idServiceQuantityOrder;

    private ServiceDetailsOrder idServiceDetailsOrder;

    private Service idService;

    private int quantityServiceReceived;

    private int quantityServiceMissing;

    private int quantityServiceSolicited;

    private String description;

    public ServiceQuantityOrderResponse() {
    }

    public ServiceQuantityOrderResponse(ServiceQuantityOrder x) {
        this.idServiceQuantityOrder = x.getIdServiceQuantityOrder();
        this.idServiceDetailsOrder = x.getIdServiceDetailsOrder();
        this.idService = x.getIdService();
        this.quantityServiceMissing = x.getQuantityServiceMissing();
        this.quantityServiceReceived = x.getQuantityServiceReceived();
        this.quantityServiceSolicited = x.getQuantityServiceSolicited();
        this.description = x.getObservations();
    }


    public int getIdServiceQuantityOrder() {
        return idServiceQuantityOrder;
    }

    public void setIdServiceQuantityOrder(int idServiceQuantityOrder) {
        this.idServiceQuantityOrder = idServiceQuantityOrder;
    }

    public ServiceDetailsOrder getIdServiceDetailsOrder() {
        return idServiceDetailsOrder;
    }

    public void setIdServiceDetailsOrder(ServiceDetailsOrder idServiceDetailsOrder) {
        this.idServiceDetailsOrder = idServiceDetailsOrder;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public int getQuantityServiceReceived() {
        return quantityServiceReceived;
    }

    public void setQuantityServiceReceived(int quantityServiceReceived) {
        this.quantityServiceReceived = quantityServiceReceived;
    }

    public int getQuantityServiceMissing() {
        return quantityServiceMissing;
    }

    public void setQuantityServiceMissing(int quantityServiceMissing) {
        this.quantityServiceMissing = quantityServiceMissing;
    }

    public int getQuantityServiceSolicited() {
        return quantityServiceSolicited;
    }

    public void setQuantityServiceSolicited(int quantityServiceSolicited) {
        this.quantityServiceSolicited = quantityServiceSolicited;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
