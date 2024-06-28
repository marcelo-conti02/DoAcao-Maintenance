package com.ages.doacaobackend.business.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ages.doacaobackend.business.enums.GeneralStatus;

@Entity
@Table(name = "item_solicitation")
public class ItemSolicitation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_item_solicitation")
    private int idItemSolicitation;

    @OneToOne(targetEntity = Institution.class)
    @JoinColumn(name = "id_institution")
    private Institution idInstitution;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "item")
    private String item;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private GeneralStatus status;

    public ItemSolicitation() {}

    public ItemSolicitation(int idItemSolicitation, Institution idInstitution, LocalDateTime createdTime, String item, GeneralStatus status) {
        this.idItemSolicitation = idItemSolicitation;
        this.idInstitution = idInstitution;
        this.createdTime = createdTime;
        this.item = item;
        this.status = status;
    }


    public int getIdItemSolicitation() {
        return this.idItemSolicitation;
    }

    public void setIdItemSolicitation(int idItemSolicitation) {
        this.idItemSolicitation = idItemSolicitation;
    }

    public Institution getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
    }

    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public GeneralStatus getStatus() {
        return this.status;
    }

    public void setStatus(GeneralStatus status) {
        this.status = status;
    }

    public ItemSolicitation withIdItemSolicitation(int idItemSolicitation) {
        this.idItemSolicitation = idItemSolicitation;
        return this;
    }

    public ItemSolicitation withIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ItemSolicitation withCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ItemSolicitation withItem(String item) {
        this.item = item;
        return this;
    }

    public ItemSolicitation withStatus(GeneralStatus status) {
        this.status = status;
        return this;
    }    
}
