package com.ages.doacaobackend.business.dto.Institution;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class InstitutionEditStatusRequest {

    @NotNull(message = "Id não pode ser nulo")
    @NotBlank(message = "Id não pode estar em branco")
    private Integer id;

    @NotNull(message = "Status não pode ser nulo")
    @NotBlank(message = "Status não pode estar em branco")
    private String status;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
