package com.ages.doacaobackend.business.dto.Item;

public class ItemResponse {

    private int idItem;

    private String name;

    private int limitItens;

    private String unitMeasurement;

    public ItemResponse(int idItem, String name, int limitItens, String unitMeasurement) {
        this.idItem = idItem;
        this.name = name;
        this.limitItens = limitItens;
        this.unitMeasurement = unitMeasurement;
    }

    public ItemResponse() {
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimitItens() {
        return limitItens;
    }

    public void setLimitItens(int limitItens) {
        this.limitItens = limitItens;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }


}
