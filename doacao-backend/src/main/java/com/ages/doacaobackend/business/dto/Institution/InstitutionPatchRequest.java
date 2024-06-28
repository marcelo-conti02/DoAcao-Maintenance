package com.ages.doacaobackend.business.dto.Institution;

import javax.validation.constraints.Email;

public class InstitutionPatchRequest {
    private int id;

    private String address;

    private String name;

    private String login;

    private String phone;

    private String whatsapp;

    @Email(message = "Email deve ter um formato válido")
    private String email;

    private String password;

    public InstitutionPatchRequest(int id, String address, String name, String login, String phone, String whatsapp,
            String email, String password) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.login = login;
        this.whatsapp = whatsapp;
        this.email = email;
        this.password = password;
    }

    public InstitutionPatchRequest() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWhatsapp() {
        return this.whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
