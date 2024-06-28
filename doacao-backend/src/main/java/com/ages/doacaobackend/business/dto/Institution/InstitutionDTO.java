package com.ages.doacaobackend.business.dto.Institution;

import com.ages.doacaobackend.business.entity.User;
import com.ages.doacaobackend.business.enums.GeneralStatus;

public class InstitutionDTO {

    private int id_institution;
    private User id_user;
    private String cnpj;
    private String name;
    private String phone;
    private String whatsapp;
    private String email;
    private String street;
    private String city;
    private String complement;
    private String state;
    private GeneralStatus status;
    private String website;
    private String socialMedia;
    private String otherSocialMedia;
    private String description;
    private String cep;
    private String district;

    public InstitutionDTO(){

    }
    public InstitutionDTO(int id_institution, User id_user, String cnpj, String name, String phone, String whatsapp, String email, String street, String city, String complement, String state, GeneralStatus status, String website, String socialMedia, String otherSocialMedia, String description, String cep, String district) {
        this.id_institution = id_institution;
        this.id_user = id_user;
        this.cnpj = cnpj;
        this.name = name;
        this.phone = phone;
        this.whatsapp = whatsapp;
        this.email = email;
        this.street = street;
        this.city = city;
        this.complement = complement;
        this.state = state;
        this.status = status;
        this.website = website;
        this.socialMedia = socialMedia;
        this.otherSocialMedia = otherSocialMedia;
        this.description = description;
        this.cep = cep;
        this.district = district;
    }

    public int getId_institution() {
        return id_institution;
    }

    public void setId_institution(int id_institution) {
        this.id_institution = id_institution;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public GeneralStatus getStatus() {
        return status;
    }

    public void setStatus(GeneralStatus status) {
        this.status = status;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getOtherSocialMedia() {
        return otherSocialMedia;
    }

    public void setOtherSocialMedia(String otherSocialMedia) {
        this.otherSocialMedia = otherSocialMedia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
