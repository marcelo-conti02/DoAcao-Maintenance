package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_order_interest")
public class ProductOrderInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_product_order_interest")
    private int idProductOrderInterest;

    @OneToOne(targetEntity = ProductDetailsOrder.class)
    @JoinColumn(name = "id_product_details_order")
    private ProductDetailsOrder idProductDetailsOrder;

    @OneToOne(targetEntity = Institution.class)
    @JoinColumn(name = "id_institution")
    private Institution idInstitution;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "active")
    private Boolean active;

    public ProductOrderInterest() {
    }

    public ProductOrderInterest(int idProductInterest, ProductDetailsOrder productDetailsOrder, Institution institution, String name, String email,
                                String phone, Boolean active) {
        this.idProductOrderInterest = idProductInterest;
        this.idProductDetailsOrder = productDetailsOrder;
        this.idInstitution = institution;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.active = active;
    }

    public int getIdProductOrderInterest() {
        return idProductOrderInterest;
    }

    public void setIdProductOrderInterest(int idProductOrderInterest) {
        this.idProductOrderInterest = idProductOrderInterest;
    }

    public ProductDetailsOrder getIdProductDetailsOrder() {
        return idProductDetailsOrder;
    }

    public void setIdProductDetailsOrder(ProductDetailsOrder idProductDetailsOrder) {
        this.idProductDetailsOrder = idProductDetailsOrder;
    }

    public Institution getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
