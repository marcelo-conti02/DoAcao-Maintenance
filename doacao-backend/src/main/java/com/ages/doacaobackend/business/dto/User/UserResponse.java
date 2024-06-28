package com.ages.doacaobackend.business.dto.User;

public class UserResponse {
    private int id_user;

    private int id_institution;

    private int id_adm;

    private boolean isAdmin;

    private String cnpj;

    private String name;

    private String phone;

    private String whatsapp;

    private String email;

    private String street;

    private String city;

    private String state;


    public UserResponse(int id_user, int id_institution, int id_adm, boolean isAdmin, String cnpj, String name, 
            String phone, String whatsapp, String email, String street, String city, String state) {

        this.id_user = id_user;
        this.id_institution = id_institution;
        this.id_adm = id_adm;
        this.isAdmin = isAdmin;
        this.cnpj = cnpj;
        this.name = name;
        this.phone = phone;
        this.whatsapp = whatsapp;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public UserResponse() {

    }


    public int getId_user() {
        return this.id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_institution() {
        return this.id_institution;
    }

    public void setId_institution(int id_institution) {
        this.id_institution = id_institution;
    }

    public int getId_adm() {
        return this.id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public UserResponse withId_User(int id_user) {
        this.id_user= id_user;
        return this;
    }

    public UserResponse withId_Institution(int id_institution) {
        this.id_institution = id_institution;
        return this;
    }

    public UserResponse withId_Admin(int id_adm) {
        this.id_adm = id_adm;
        return this;
    }

    public UserResponse withIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    public UserResponse withCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public UserResponse withName(String name) {
        this.name = name;
        return this;
    }

    public UserResponse withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserResponse withWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        return this;
    }

    public UserResponse withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserResponse withStreet(String street) {
        this.street = street;
        return this;
    }

    public UserResponse withCity(String city) {
        this.city = city;
        return this;
    }
    
    public UserResponse withState(String state) {
        this.state = state;
        return this;
    }
}
