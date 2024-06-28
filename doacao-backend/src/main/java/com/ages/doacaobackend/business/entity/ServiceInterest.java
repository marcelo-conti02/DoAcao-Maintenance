package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "service_interest")
public class ServiceInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_service_interest")
    private int idServiceInterest;

    @ManyToOne
    @JoinColumn(name = "id_service_order_interest")
    private ServiceOrderInterest idServiceOrderInterest;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "id_service")
    private Service idService;

    @Column(name = "quantity")
    private int quantity;

    public ServiceInterest() {
    }

    public ServiceInterest(ServiceOrderInterest idServiceInterest, Service idService, int quantity) {
        this.idServiceOrderInterest = idServiceInterest;
        this.idService = idService;
        this.quantity = quantity;
    }

    public ServiceOrderInterest getServiceOrderInterest() {
        return idServiceOrderInterest;
    }

    public void setServiceOrderInterest(ServiceOrderInterest serviceOrderInterest) {
        this.idServiceOrderInterest = serviceOrderInterest;
    }

    public Service getService() {
        return idService;
    }

    public void setService(Service service) {
        this.idService = service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdServiceInterest() {
        return idServiceInterest;
    }

    public void setIdServiceInterest(int idServiceInterest) {
        this.idServiceInterest = idServiceInterest;
    }
}
