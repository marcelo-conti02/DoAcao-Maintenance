package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "service_order_interest")
public class ServiceOrderInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_service_order_interest")
    private int idServiceOrderInterest;

    @OneToOne(targetEntity = ServiceDetailsOrder.class)
    @JoinColumn(name = "id_service_details_order")
    private ServiceDetailsOrder idServiceDetailsOrder;

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
    private String active;

    public ServiceOrderInterest() {
    }

    public ServiceOrderInterest(int idServiceInterest, ServiceDetailsOrder idServiceDetailsOrder,
            Institution institution,
            String name, String email, String phone, String active) {
        this.idServiceOrderInterest = idServiceInterest;
        this.idServiceDetailsOrder = idServiceDetailsOrder;
        this.idInstitution = institution;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.active = active;
    }

    public int getIdInterest() {
        return idServiceOrderInterest;
    }

    public void setIdServiceOrderInterest(int idServiceOrderInterest) {
        this.idServiceOrderInterest = idServiceOrderInterest;
    }

    public ServiceDetailsOrder getServiceDetailsOrder() {
        return idServiceDetailsOrder;
    }

    public void setServiceDetailsOrder(ServiceDetailsOrder serviceDetailsOrder) {
        this.idServiceDetailsOrder = serviceDetailsOrder;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
