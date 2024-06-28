package com.ages.doacaobackend.business.dto.ItemSolicitation;

import java.time.LocalDateTime;

import com.ages.doacaobackend.business.entity.ItemSolicitation;
import com.ages.doacaobackend.business.enums.GeneralStatus;

public class ItemSolicitationResponse {
    private int idItemSolicitation;

    private int idInstitution;

    private LocalDateTime createdTime;

    private String item;

    private GeneralStatus generalStatus;

    public ItemSolicitationResponse() {}

    public ItemSolicitationResponse(int idItemSolicitation, int idInstitution, LocalDateTime createdTime, String item, GeneralStatus generalStatus) {
        this.idItemSolicitation = idItemSolicitation;
        this.idInstitution = idInstitution;
        this.createdTime = createdTime;
        this.item = item;
        this.generalStatus = generalStatus;
    }

    public ItemSolicitationResponse(ItemSolicitation i) {
        this.idItemSolicitation = i.getIdItemSolicitation();
        this.idInstitution = i.getIdInstitution().getId_institution();
        this.createdTime = i.getCreatedTime();
        this.item = i.getItem();
        this.generalStatus = i.getStatus();
    }


    public int getIdItemSolicitation() {
        return this.idItemSolicitation;
    }

    public void setIdItemSolicitation(int idItemSolicitation) {
        this.idItemSolicitation = idItemSolicitation;
    }

    public int getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
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

    public GeneralStatus getGeneralStatus() {
        return this.generalStatus;
    }

    public void setGeneralStatus(GeneralStatus generalStatus) {
        this.generalStatus = generalStatus;
    }

    public ItemSolicitationResponse withIdItemSolicitationResponse(int idItemSolicitation) {
        this.idItemSolicitation = idItemSolicitation;
        return this;
    }

    public ItemSolicitationResponse withIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ItemSolicitationResponse withCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ItemSolicitationResponse withItem(String item) {
        this.item = item;
        return this;
    }

    public ItemSolicitationResponse withGeneralStatus(GeneralStatus generalStatus) {
        this.generalStatus = generalStatus;
        return this;
    }
}
