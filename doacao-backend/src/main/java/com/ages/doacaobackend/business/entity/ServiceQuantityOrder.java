package com.ages.doacaobackend.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "service_quantity_order")
public class ServiceQuantityOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_service_quantity_order")
    private int idServiceQuantityOrder;

    @OneToOne(targetEntity = Institution.class)
    @JoinColumn(name = "id_institution")
    private Institution idInstitution;

    @OneToOne(targetEntity = ServiceDetailsOrder.class)
    @JoinColumn(name = "id_service_details_order")
    private ServiceDetailsOrder idServiceDetailsOrder;

    @OneToOne(targetEntity = Service.class)
    @JoinColumn(name = "id_service")
    private Service idService;

    @Column(name = "qtd_service_received")
    private int quantityServiceReceived;

    @Column(name = "qtd_service_missing")
    private int quantityServiceMissing;

    @Column(name = "qtd_service_solicited")
    private int quantityServiceSolicited;

    @Column(name = "observations")
    private String observations;

    public ServiceQuantityOrder(int idServiceQuantityOrder, Institution idInstitution, ServiceDetailsOrder idServiceDetailsOrder, Service idService, int quantityServiceReceived,
                                int quantityServiceMissing, int quantityServiceSolicited, String observations) {

        this.idServiceQuantityOrder = idServiceQuantityOrder;
        this.idInstitution = idInstitution;
        this.idServiceDetailsOrder = idServiceDetailsOrder;
        this.idService = idService;
        this.quantityServiceReceived = quantityServiceReceived;
        this.quantityServiceMissing = quantityServiceMissing;
        this.quantityServiceSolicited = quantityServiceSolicited;
        this.observations = observations;
    }

    public ServiceQuantityOrder() {
    }


    public int getIdServiceQuantityOrder() {
        return this.idServiceQuantityOrder;
    }

    public void setIdServiceQuantityOrder(int idServiceQuantityOrder) {
        this.idServiceQuantityOrder = idServiceQuantityOrder;
    }

    public Institution getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
    }

    public ServiceDetailsOrder getIdServiceDetailsOrder() {
        return this.idServiceDetailsOrder;
    }

    public void setIdServiceDetailsOrder(ServiceDetailsOrder idServiceDetailsOrder) {
        this.idServiceDetailsOrder = idServiceDetailsOrder;
    }

    public Service getIdService() {
        return this.idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public int getQuantityServiceReceived() {
        return this.quantityServiceReceived;
    }

    public void setQuantityServiceReceived(int quantityServiceReceived) {
        this.quantityServiceReceived = quantityServiceReceived;
    }

    public int getQuantityServiceMissing() {
        return this.quantityServiceMissing;
    }

    public void setQuantityServiceMissing(int quantityServiceMissing) {
        this.quantityServiceMissing = quantityServiceMissing;
    }

    public int getQuantityServiceSolicited() {
        return this.quantityServiceSolicited;
    }

    public void setQuantityServiceSolicited(int quantityServiceSolicited) {
        this.quantityServiceSolicited = quantityServiceSolicited;
    }

    public ServiceQuantityOrder withIdServiceQuantityOrder(int idServiceQuantityOrder) {
        this.idServiceQuantityOrder = idServiceQuantityOrder;
        return this;
    }

    public ServiceQuantityOrder withIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ServiceQuantityOrder withIdServiceDetailsOrder(ServiceDetailsOrder idServiceDetailsOrder) {
        this.idServiceDetailsOrder = idServiceDetailsOrder;
        return this;
    }

    public ServiceQuantityOrder withIdService(Service idService) {
        this.idService = idService;
        return this;
    }

    public ServiceQuantityOrder withQuantityServiceReceived(int quantityServiceReceived) {
        this.quantityServiceReceived = quantityServiceReceived;
        return this;
    }

    public ServiceQuantityOrder withQuantityServiceMissing(int quantityServiceMissing) {
        this.quantityServiceMissing = quantityServiceMissing;
        return this;
    }

    public ServiceQuantityOrder withObservations(String observations) {
        this.observations = observations;
        return this;
    }

    public ServiceQuantityOrder withQuantityServiceSolicited(int quantityServiceSolicited) {
        this.quantityServiceSolicited = quantityServiceSolicited;
        return this;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
