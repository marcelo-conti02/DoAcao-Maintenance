package com.ages.doacaobackend.business.dto.Institution;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class InstitutionRequest {

    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode estar em branco")
    private String name;

    @NotNull(message = "CNPJ não pode ser nulo")
    @NotBlank(message = "CNPJ não pode estar em branco")
    @CNPJ(message = "CNPJ deve estar em um formato válido")
    private String cnpj;

    @NotNull(message = "Login não pode ser nulo")
    @NotBlank(message = "Login não pode estar em branco")
    private String login;

    @NotNull(message = "Telefone não pode ser nulo")
    @NotBlank(message = "Telefone não pode estar em branco")
    private String phone;

    @NotNull(message = "Whatsapp não pode ser nulo")
    @NotBlank(message = "Whatsapp não pode estar em branco")
    private String whatsapp;

    @NotNull(message = "Email não pode ser nulo")
    @NotBlank(message = "Email não pode estar em branco")
    @Email(message = "Email deve ter um formato válido")
    private String email;

    @NotNull(message = "Senha não pode ser nulo")
    @NotBlank(message = "Senha não pode estar em branco")
    private String password;

    @NotNull(message = "Rua não pode ser nulo")
    @NotBlank(message = "Rua não pode estar em branco")
    private String street;

    @NotNull(message = "Cidade não pode ser nulo")
    @NotBlank(message = "Cidade não pode estar em branco")
    private String city;

    @NotNull(message = "Estado não pode ser nulo")
    @NotBlank(message = "Estado não pode estar em branco")
    private String state;

    private String complement;

    private String website;

    @NotNull(message = "Rede social não pode ser nulo")
    @NotBlank(message = "Rede social não pode estar em branco")
    private String socialMedia;

    private String otherSocialMedia;

    @NotNull(message = "Descrição não pode ser nulo")
    @NotBlank(message = "Descrição não pode estar em branco")
    private String description;

    @NotNull(message = "CEP não pode ser nulo")
    @NotBlank(message = "CEP não pode estar em branco")
    private String cep;

    @NotNull(message = "Bairro não pode ser nulo")
    @NotBlank(message = "Bairro não pode estar em branco")
    private String district;

    public InstitutionRequest(String name, String cnpj, String login, String phone, String whatsapp,
            String email, String password, String street, String city, String state, String complement,
            String website, String socialMedia, String otherSocialMedia, String description,
            String cep, String district) {
        this.name = name;
        this.cnpj = cnpj;
        this.phone = phone;
        this.login = login;
        this.whatsapp = whatsapp;
        this.email = email;
        this.password = password;
        this.street = street;
        this.city = city;
        this.state = state;
        this.complement = complement;
        this.website = website;
        this.socialMedia = socialMedia;
        this.otherSocialMedia = otherSocialMedia;
        this.description = description;
        this.cep = cep;
        this.district = district;
    }

    public InstitutionRequest() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public InstitutionRequest withName(String name) {
        this.name = name;
        return this;
    }

    public InstitutionRequest withCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public InstitutionRequest withLogin(String login) {
        this.login = login;
        return this;
    }

    public InstitutionRequest withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public InstitutionRequest withWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        return this;
    }

    public InstitutionRequest withEmail(String email) {
        this.email = email;
        return this;
    }

    public InstitutionRequest withPassword(String password) {
        this.password = password;
        return this;
    }

    public InstitutionRequest withCity(String city) {
        this.city = city;
        return this;
    }

    public InstitutionRequest withStreet(String street) {
        this.street = street;
        return this;
    }

    public InstitutionRequest withState(String state) {
        this.state = state;
        return this;
    }
}
