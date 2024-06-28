package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name ="itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_item")
    private int idItem;

    @Column(name = "name")
    private String name;

    @Column(name = "limit_itens")
    private int limitItens;

    @Column(name = "unit_measurement")
    private String unitMeasurement;


    public Item(int idItem, String name, int limitItens, String unitMeasurement) {
        this.idItem = idItem;
        this.name = name;
        this.limitItens = limitItens;
        this.unitMeasurement = unitMeasurement;
    }

    public Item() {
    }

    public int getIdItem() {
        return idItem;
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

    public Item withIdItem(int idItem) {
        this.idItem = idItem;
        return this;
    }

    public Item withName(String name) {
        this.name = name;
        return this;
    }

    public Item withLimitItens(int limitItens) {
        this.limitItens = limitItens;
        return this;
    }

    public Item withUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
        return this;
    }


}
