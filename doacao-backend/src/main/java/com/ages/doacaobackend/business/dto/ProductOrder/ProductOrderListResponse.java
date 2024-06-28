package com.ages.doacaobackend.business.dto.ProductOrder;


import java.time.LocalDateTime;
import java.util.List;

public class ProductOrderListResponse {
    private int idProductOrder;

    private int idInstitution;

    private String institutionDescription;

    private String institutionName;

    private boolean isUrgent;

    private LocalDateTime createdTime;

    private LocalDateTime limitDate;

    private List<ProductQuantityOrderResponse> itens; //TODO mudar pra DTO

    public ProductOrderListResponse(int idProductOrder, int idInstitution, String institutionDescription, String institutionName, boolean isUrgent, LocalDateTime createdTime, LocalDateTime limitDate, List<ProductQuantityOrderResponse> itens) {
        this.idProductOrder = idProductOrder;
        this.idInstitution = idInstitution;
        this.institutionDescription = institutionDescription;
        this.institutionName = institutionName;
        this.isUrgent = isUrgent;
        this.createdTime = createdTime;
        this.limitDate = limitDate;
        this.itens = itens;
    }

    public ProductOrderListResponse(int idProductOrder, int idInstitution, boolean isUrgent, LocalDateTime createdTime, LocalDateTime limitDate, List<ProductQuantityOrderResponse> itens) {
        this.idProductOrder = idProductOrder;
        this.idInstitution = idInstitution;
        this.isUrgent = isUrgent;
        this.createdTime = createdTime;
        this.limitDate = limitDate;
        this.itens = itens;
    }

    public ProductOrderListResponse() {}

    public int getIdProductOrder() {
        return this.idProductOrder;
    }

    public void setIdProductOrder(int idProductOrder) {
        this.idProductOrder = idProductOrder;
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

    public List<ProductQuantityOrderResponse> getItens() {
        return this.itens;
    }

    public void setItens(List<ProductQuantityOrderResponse> itens) {
        this.itens = itens;
    }

    public ProductOrderListResponse withIdProductOrder(int idProductOrder) {
        this.idProductOrder = idProductOrder;
        return this;
    }

    public ProductOrderListResponse withIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ProductOrderListResponse withIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
        return this;
    }

    public ProductOrderListResponse withCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ProductOrderListResponse withLimitDate(LocalDateTime limitDate) {
        this.limitDate = limitDate;
        return this;
    }

    public ProductOrderListResponse withItens(List<ProductQuantityOrderResponse> itens) {
        this.itens = itens;
        return this;
    }

    public ProductOrderListResponse withInstitutionName(String institutionName) {
        this.institutionName = institutionName;
        return this;
    }

    public ProductOrderListResponse withInstitutionDescription(String institutionDescription) {
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
}
