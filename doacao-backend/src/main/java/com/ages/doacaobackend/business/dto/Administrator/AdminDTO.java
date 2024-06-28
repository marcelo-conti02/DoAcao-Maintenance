package com.ages.doacaobackend.business.dto.Administrator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AdminDTO {

    @NotNull(message = "Id_adm não pode ser nulo")
    @NotBlank(message = "Id_adm não pode estar em branco")
    private int id_adm;

    @NotNull(message = "Name não pode ser nulo")
    @NotBlank(message = "Name não pode estar em branco")
    private String name;

    @NotNull(message = "Email não pode ser nulo")
    @NotBlank(message = "Email não pode estar em branco")
    @Email(message = "Email deve ter um formato válido")
    private String email;

    public AdminDTO(int id_adm, String name, String email) {
        this.id_adm = id_adm;
        this.name = name;
        this.email = email;
    }

    public AdminDTO() {

    }

    public int getId_adm() {
        return this.id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdminDTO withId_adm(int id_adm) {
        this.id_adm = id_adm;
        return this;
    }

    public AdminDTO withName(String name) {
        this.name = name;
        return this;
    }

    public AdminDTO withEmail(String email) {
        this.email = email;
        return this;
    }
}
