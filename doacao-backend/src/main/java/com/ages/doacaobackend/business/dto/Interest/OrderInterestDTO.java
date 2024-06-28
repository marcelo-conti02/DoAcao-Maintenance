package com.ages.doacaobackend.business.dto.Interest;

import java.util.List;

public class OrderInterestDTO {

    private int orderInterestId;
    private int orderId;
    private int idInstitution;
    private String name;
    private String phone;
    private String email;
    private List<OrderInterestsDTO> interests;

    public OrderInterestDTO() {
    }

    public OrderInterestDTO(int orderInterestId, int orderId, int idInstitution, String name, String phone, String email, List<OrderInterestsDTO> interests) {
        this.orderInterestId = orderInterestId;
        this.orderId = orderId;
        this.idInstitution = idInstitution;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.interests = interests;
    }

    public int getOrderInterestId() {
        return orderInterestId;
    }

    public void setOrderInterestId(int orderInterestId) {
        this.orderInterestId = orderInterestId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderInterestsDTO> getInterests() {
        return interests;
    }

    public void setInterests(List<OrderInterestsDTO> interests) {
        this.interests = interests;
    }
}
