package com.ages.doacaobackend.business.dto.ProductOrder;

import com.ages.doacaobackend.business.entity.Item;
import com.ages.doacaobackend.business.entity.ProductDetailsOrder;
import com.ages.doacaobackend.business.entity.ProductQuantityOrder;

public class ProductQuantityOrderResponse {
    
    private int idProductQuantityOrder;
    private ProductDetailsOrder idProductDetailsOrder; //TODO mudar para DTO
    private Item idItem; //TODO mudar para DTO
    private int quantityProductsReceived;
    private int quantityProductsMissing;
    private int quantityProductsSolicited;

    private String description;
    public ProductQuantityOrderResponse() {

    }
    public ProductQuantityOrderResponse(int idProductQuantityOrder, ProductDetailsOrder idProductDetailsOrder, Item idItem, int quantityProductsReceived, int quantityProductsMissing, int quantityProductsSolicited) {
        this.idProductQuantityOrder = idProductQuantityOrder;
        this.idProductDetailsOrder = idProductDetailsOrder;
        this.idItem = idItem;
        this.quantityProductsReceived = quantityProductsReceived;
        this.quantityProductsMissing = quantityProductsMissing;
        this.quantityProductsSolicited = quantityProductsSolicited;
    }

    public ProductQuantityOrderResponse(ProductQuantityOrder x) {
        this.idProductQuantityOrder = x.getIdProductQuantityOrder();
        this.idProductDetailsOrder = x.getIdProductDetailsOrder();
        this.idItem = x.getIdItem();
        this.quantityProductsReceived = x.getQuantityProductsReceived();
        this.quantityProductsMissing = x.getQuantityProductsMissing();
        this.quantityProductsSolicited = x.getQuantityProductsSolicited();
        this.description = x.getObservations();
    }

    public int getIdProductQuantityOrder() {
        return idProductQuantityOrder;
    }

    public void setIdProductQuantityOrder(int idProductQuantityOrder) {
        this.idProductQuantityOrder = idProductQuantityOrder;
    }

    public ProductDetailsOrder getIdProductDetailsOrder() {
        return idProductDetailsOrder;
    }

    public void setIdProductDetailsOrder(ProductDetailsOrder idProductDetailsOrder) {
        this.idProductDetailsOrder = idProductDetailsOrder;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public int getQuantityProductsReceived() {
        return quantityProductsReceived;
    }

    public void setQuantityProductsReceived(int quantityProductsReceived) {
        this.quantityProductsReceived = quantityProductsReceived;
    }

    public int getQuantityProductsMissing() {
        return quantityProductsMissing;
    }

    public void setQuantityProductsMissing(int quantityProductsMissing) {
        this.quantityProductsMissing = quantityProductsMissing;
    }

    public int getQuantityProductsSolicited() {
        return quantityProductsSolicited;
    }

    public void setQuantityProductsSolicited(int quantityProductsSolicited) {
        this.quantityProductsSolicited = quantityProductsSolicited;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductQuantityOrderResponse fromEntity(ProductQuantityOrder productQuantityOrder){
        this.idItem = productQuantityOrder.getIdItem();
        this.idProductDetailsOrder = productQuantityOrder.getIdProductDetailsOrder();
        this.quantityProductsMissing = productQuantityOrder.getQuantityProductsMissing();
        this.quantityProductsReceived = productQuantityOrder.getQuantityProductsReceived();
        this.quantityProductsSolicited = productQuantityOrder.getQuantityProductsSolicited();
        this.idProductQuantityOrder = productQuantityOrder.getIdProductQuantityOrder();
        this.description = productQuantityOrder.getObservations();
        return this;
    }
}
