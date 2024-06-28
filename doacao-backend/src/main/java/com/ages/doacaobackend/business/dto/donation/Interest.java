package com.ages.doacaobackend.business.dto.donation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Interest {

    @NotNull(message = "interestName não pode ser nulo")
    private String interestName;
    @NotNull(message = "quantidade não pode ser negativa")
    @Positive(message = "quantidade não pode ser nula")
    private int amount;

    public Interest(String interestName, int amount) {
        this.interestName = interestName;
        this.amount = amount;
    }

    public Interest() {
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
