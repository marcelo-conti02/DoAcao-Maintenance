package com.ages.doacaobackend.business.dto.Institution;

import com.ages.doacaobackend.business.dto.User.UserDTO;

import java.time.LocalDateTime;

public class InstitutionResponse {
    
    private int id_institution;

    private UserDTO id_user;

    private String name;

    private String phone;

    private String whatsapp;

    private String email;

    private String cnpj;

    private String street;

    private String city;

    private String state;

    private String status;

    private LocalDateTime createdTime;

    private String complement;

    private String website;

    private String socialMedia;

    private String otherSocialMedia;

    private String description;

    private String cep;

    private String district;

    public InstitutionResponse(int id_institution, UserDTO id_user, String name, String phone, String whatsapp, 
            String email, String cnpj, String street, String city, String state, String status, LocalDateTime createdTime,
            String complement, String website, String socialMedia, String otherSocialMedia, String description,
            String cep, String district) {

        this.id_institution = id_institution;
        this.id_user = id_user;
        this.name = name;
        this.phone = phone;
        this.whatsapp = whatsapp;
        this.email = email;
        this.cnpj = cnpj;
        this.street = street;
        this.city = city;
        this.state = state;
        this.status = status;
        this.createdTime = createdTime;
        this.complement = complement;
        this.website = website;
        this.socialMedia = socialMedia;
        this.otherSocialMedia = otherSocialMedia;
        this.description = description;
        this.cep = cep;
        this.district = district;
    }

    public InstitutionResponse() {

    }

    public int getId_institution() {
        return this.id_institution;
    }

    public void setId_institution(int id_institution) {
        this.id_institution = id_institution;
    }

    public UserDTO getId_user() {
        return this.id_user;
    }
    
    public void setId_user(UserDTO id_user) {
        this.id_user = id_user;
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

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSocialMedia() {
        return this.socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getOtherSocialMedia() {
        return this.otherSocialMedia;
    }

    public void setOtherSocialMedia(String otherSocialMedia) {
        this.otherSocialMedia = otherSocialMedia;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public InstitutionResponse withId_Institution(int id_institution) {
        this.id_institution = id_institution;
        return this;
    }

    public InstitutionResponse withName(String name) {
        this.name = name;
        return this;
    }

    public InstitutionResponse withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public InstitutionResponse withWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        return this;
    }

    public InstitutionResponse withEmail(String email) {
        this.email = email;
        return this;
    }

    public InstitutionResponse withComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public InstitutionResponse withWebsite(String website) {
        this.website = website;
        return this;
    }

    public InstitutionResponse withSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
        return this;
    }

    public InstitutionResponse withOtherSocialMedia(String otherSocialMedia) {
        this.otherSocialMedia = otherSocialMedia;
        return this;
    }

    public InstitutionResponse withDescription(String description) {
        this.description = description;
        return this;
    }

    public InstitutionResponse withCep(String cep) {
        this.cep = cep;
        return this;
    }

    public InstitutionResponse withDistrict(String district) {
        this.district = district;
        return this;
    }
}
