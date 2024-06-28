package com.ages.doacaobackend.business.dto.ProductOrder;

import java.util.List;

public class ProductOrderRequest {

    private int idInstitution;

    private boolean isUrgent;

    private List<ProductQuantityOrderRequest> items;

    private String description;

    public ProductOrderRequest(){}

    public ProductOrderRequest(int idInstitution, boolean isUrgent, List<ProductQuantityOrderRequest> items,
                               String description) {
        this.idInstitution = idInstitution;
        this.isUrgent = isUrgent;
        this.items = items;
        this.description = description;
    }

    public int getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public boolean getIsUrgent() {
        return this.isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public List<ProductQuantityOrderRequest> getItem() {
        return items;
    }

    public void setItem(List<ProductQuantityOrderRequest> items) {
        this.items = items;
    }

    public List<ProductQuantityOrderRequest> getItems() {
        return items;
    }

    public void setItems(List<ProductQuantityOrderRequest> items) {
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductOrderRequest withIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ProductOrderRequest withIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
        return this;
    }

    public ProductOrderRequest withItems(List<ProductQuantityOrderRequest> items) {
        this.items = items;
        return this;
    }

    public ProductOrderRequest withDescription(String description) {
        this.description = description;
        return this;
    }
}
