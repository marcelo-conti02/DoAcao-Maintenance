package com.ages.doacaobackend.business.dto.donation;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class DonationInterestRequest {

    @Valid
    private List<Interest> itemsAndQuantities;
    @NotNull(message = "orderId não pode ser nulo")
    private int orderId;
    @NotNull(message = "name não pode ser nulo")
    @NotBlank(message = "name não pode estar em branco")
    private String name;
    private String email;
    private String phone;

    public DonationInterestRequest(List<Interest> itemsAndQuantities, int orderId, String name, String email, String phone) {
        this.itemsAndQuantities = itemsAndQuantities;
        this.orderId = orderId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public DonationInterestRequest() {}

    public List<Interest> getItemsAndQuantities() {
        return itemsAndQuantities;
    }

    public void setItemsAndQuantities(List<Interest> itemsAndQuantities) {
        this.itemsAndQuantities = itemsAndQuantities;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
}
