package com.ages.doacaobackend.business.dto.Interest;

public class OrderInterestsDTO {

    private String itemName;
    private int amount;

    public OrderInterestsDTO(String itemName, int amount) {
        this.itemName = itemName;
        this.amount = amount;
    }

    public OrderInterestsDTO() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
