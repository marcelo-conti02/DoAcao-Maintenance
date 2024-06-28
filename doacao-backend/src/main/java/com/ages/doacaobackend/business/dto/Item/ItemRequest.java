package com.ages.doacaobackend.business.dto.Item;

import javax.validation.constraints.DecimalMin;

public class ItemRequest {

    private String name;

    @DecimalMin(value = "1", message = "Limite deve ser maior que 0")
    private int limitItens;

    private String unitMeasurement;

    public ItemRequest(String name, int limitItens, String unitMeasurement) {
        this.name = name;
        this.limitItens = limitItens;
        this.unitMeasurement = unitMeasurement;
    }

    public ItemRequest() {
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

    public ItemRequest withName(String name) {
        this.name = name;
        return this;
    }

    public ItemRequest withLimitItens(int limitItens) {
        this.limitItens = limitItens;
        return this;
    }

    public ItemRequest withUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
        return this;
    }
}
