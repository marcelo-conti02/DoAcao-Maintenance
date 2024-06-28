package com.ages.doacaobackend.business.dto.ProductOrder;

public class ProductQuantityOrderRequest {
    private int idItem;

    private int quantitySolicited;

    private String description;

    private String unitMeasurement;

    public ProductQuantityOrderRequest() {}

    public ProductQuantityOrderRequest(int idItem, int quantitySolicited, String description, String unitMeasurement) {
        this.idItem = idItem;
        this.quantitySolicited = quantitySolicited;
        this.description = description;
        this.unitMeasurement = unitMeasurement;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getQuantitySolicited() {
        return quantitySolicited;
    }

    public void setQuantitySolicited(int quantitySolicited) {
        this.quantitySolicited = quantitySolicited;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {this.description = description;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void unitMeasurement(String unitMeasurement) {
        this.description = unitMeasurement;
    }

    public ProductQuantityOrderRequest withIdItem(int idItem) {
        this.idItem = idItem;
        return this;
    }

    public ProductQuantityOrderRequest withQuantitySolicited(int quantitySolicited) {
        this.quantitySolicited = quantitySolicited;
        return this;
    }

    public ProductQuantityOrderRequest withDescription(String description) {
        this.description = description;
        return this;
    }

}
