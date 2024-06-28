package com.ages.doacaobackend.business.dto.ItemSolicitation;


public class ItemSolicitationRequest {
    private int idInstitution;

    private String item;

    public ItemSolicitationRequest() {}

    public ItemSolicitationRequest(int idInstitution, String item) {
        this.idInstitution = idInstitution;
        this.item = item;
    }

    public int getIdInstitution() {
        return this.idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    public ItemSolicitationRequest withIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public ItemSolicitationRequest withItem(String item) {
        this.item = item;
        return this;
    }
}
