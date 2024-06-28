package com.ages.doacaobackend.business.dto.ProductOrder;

import com.ages.doacaobackend.business.dto.Item.ItemResponse;
import com.ages.doacaobackend.business.enums.GeneralStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ProductOrderResponse {    
    private int idProductOrderResponse;

    private List<ItemResponse> itens;

    private LocalDateTime createdTime;

    private LocalDateTime limitDate;

    private GeneralStatus status;


    public ProductOrderResponse(int idProductOrderResponse, List<ItemResponse> itens, LocalDateTime createdTime, LocalDateTime limitDate, GeneralStatus status) {
        this.idProductOrderResponse = idProductOrderResponse;
        this.itens = itens;
        this.createdTime = createdTime;
        this.limitDate = limitDate;
        this.status = status;
    }

    public ProductOrderResponse() {}


    public int getIdProductDetailsOrder() {
        return this.idProductOrderResponse;
    }

    public void setIdProducteDetailsOrder(int idProductOrderResponse) {
        this.idProductOrderResponse = idProductOrderResponse;
    }

    public List<ItemResponse> getItens() {
        return this.itens;
    }

    public void setItens(List<ItemResponse> itens) {
        this.itens = itens;
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

    public void setIsActive(GeneralStatus status) {
        this.status = status;
    }

    public ProductOrderResponse withIdProductOrderResponse(int idProductOrderResponse) {
        this.idProductOrderResponse = idProductOrderResponse;
        return this;
    }

    public ProductOrderResponse withItens(List<ItemResponse> itens) {
        this.itens = itens;
        return this;
    }

    public ProductOrderResponse withCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ProductOrderResponse withLimitDate(LocalDateTime limitDate) {
        this.limitDate = limitDate;
        return this;
    }

    public ProductOrderResponse withStatus(GeneralStatus status) {
        this.status = status;
        return this;
    }

}
