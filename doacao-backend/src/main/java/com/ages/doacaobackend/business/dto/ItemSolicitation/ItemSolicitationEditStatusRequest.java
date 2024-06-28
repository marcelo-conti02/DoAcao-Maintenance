package com.ages.doacaobackend.business.dto.ItemSolicitation;

public class ItemSolicitationEditStatusRequest {

    private int id;

    private String status;

    public ItemSolicitationEditStatusRequest() {}

    public ItemSolicitationEditStatusRequest(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ItemSolicitationEditStatusRequest withId(int id) {
        this.id = id;
        return this;
    }

    public ItemSolicitationEditStatusRequest withStatus(String status) {
        this.status = status;
        return this;
    }
}
