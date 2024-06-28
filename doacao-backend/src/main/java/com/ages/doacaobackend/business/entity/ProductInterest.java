package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_interest")
public class ProductInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_product_interest")
    private int idProductInterest;

    @ManyToOne
    @JoinColumn(name = "id_product_order_interest")
    private ProductOrderInterest idProductOrderInterest;

    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name = "id_item")
    private Item item;

    @Column(name = "quantity")
    private int quantity;

    public ProductInterest() {
    }

    public ProductInterest(ProductOrderInterest productOrderInterest, Item item, int quantity) {
        this.idProductOrderInterest = productOrderInterest;
        this.item = item;
        this.quantity = quantity;
    }

    public ProductOrderInterest getIdProductOrderInterest() {
        return idProductOrderInterest;
    }

    public void setIdProductOrderInterest(ProductOrderInterest idProductOrderInterest) {
        this.idProductOrderInterest = idProductOrderInterest;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdProductInterest() {
        return idProductInterest;
    }

    public void setIdProductInterest(int idProductInterest) {
        this.idProductInterest = idProductInterest;
    }
}
