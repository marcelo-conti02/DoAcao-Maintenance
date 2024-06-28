package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_quantity_order")
public class ProductQuantityOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_product_quantity_order")
    private int idProductQuantityOrder;

    @OneToOne(targetEntity = Institution.class)
    @JoinColumn(name = "id_institution")
    private Institution idInstitution;

    @OneToOne(targetEntity = ProductDetailsOrder.class)
    @JoinColumn(name = "id_product_details_order")
    private ProductDetailsOrder idProductDetailsOrder;

    @OneToOne(targetEntity = Item.class)
    @JoinColumn(name = "id_item")
    private Item idItem;

    @Column(name = "qtd_products_received")
    private int quantityProductsReceived;

    @Column(name = "qtd_products_missing")
    private int quantityProductsMissing;

    @Column(name = "qtd_products_solicited")
    private int quantityProductsSolicited;

    @Column(name = "observations")
    private String observations;

    public ProductQuantityOrder(int idProductQuantityOrder, Institution idInstitution, ProductDetailsOrder idProductDetailsOrder, Item idItem, int quantityProductsReceived,
            int quantityProductsMissing, int quantityProductsSolicited) {
            
            this.idProductQuantityOrder = idProductQuantityOrder;
            this.idInstitution = idInstitution;
            this.idProductDetailsOrder = idProductDetailsOrder;
            this.idItem = idItem;
            this.quantityProductsReceived = quantityProductsReceived;
            this.quantityProductsMissing = quantityProductsMissing;
            this.quantityProductsSolicited = quantityProductsSolicited;
    }
    
    public ProductQuantityOrder() {}


    public int getIdProductQuantityOrder() {
        return this.idProductQuantityOrder;
    }

    public void setIdProductQuantityOrder(int idProductQuantityOrder) {
        this.idProductQuantityOrder = idProductQuantityOrder;
    }

    public Institution getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
    }

    public ProductDetailsOrder getIdProductDetailsOrder() {
        return this.idProductDetailsOrder;
    }

    public void setIdProductDetailsOrder(ProductDetailsOrder idProductDetailsOrder) {
        this.idProductDetailsOrder = idProductDetailsOrder;
    }

    public Item getIdItem() {
        return this.idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public int getQuantityProductsReceived() {
        return this.quantityProductsReceived;
    }

    public void setQuantityProductsReceived(int quantityProductsReceived) {
        this.quantityProductsReceived = quantityProductsReceived;
    }

    public int getQuantityProductsMissing() {
        return this.quantityProductsMissing;
    }

    public void setQuantityProductsMissing(int quantityProductsMissing) {
        this.quantityProductsMissing = quantityProductsMissing;
    }

    public int getQuantityProductsSolicited() {
        return this.quantityProductsSolicited;
    }

    public void setQuantityProductsSolicited(int quantityProductsSolicited) {
        this.quantityProductsSolicited = quantityProductsSolicited;
    }

    public ProductQuantityOrder withIdProductQuantityOrder(int idProductQuantityOrder) {
        this.idProductQuantityOrder = idProductQuantityOrder;
        return this;
    }

    public ProductQuantityOrder withIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ProductQuantityOrder withIdProductDetailsOrder(ProductDetailsOrder idProductDetailsOrder) {
        this.idProductDetailsOrder = idProductDetailsOrder;
        return this;
    }

    public ProductQuantityOrder withIdItem(Item idItem) {
        this.idItem = idItem;
        return this;
    }

    public ProductQuantityOrder withObservations(String observations) {
        this.observations = observations;
        return this;
    }

    public ProductQuantityOrder withQuantityProductsReceived(int quantityProductsReceived) {
        this.quantityProductsReceived = quantityProductsReceived;
        return this;
    }

    public ProductQuantityOrder withQuantityProductsMissing(int quantityProductsMissing) {
        this.quantityProductsMissing = quantityProductsMissing;
        return this;
    }

    public ProductQuantityOrder withQuantityProductsSolicited(int quantityProductsSolicited) {
        this.quantityProductsSolicited = quantityProductsSolicited;
        return this;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
