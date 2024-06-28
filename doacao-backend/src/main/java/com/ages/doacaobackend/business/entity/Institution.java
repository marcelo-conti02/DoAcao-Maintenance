package com.ages.doacaobackend.business.entity;

import com.ages.doacaobackend.business.enums.GeneralStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="institution")
public class Institution {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_institution")
    private int id_institution;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user")
    private User id_user;

    @Column(name = "cnpj")
    private String cnpj;
  
    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "whatsapp")
    private String whatsapp;

    @Column(name = "email")
    private String email;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private GeneralStatus status;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "complement")
    private String complement;

    @Column(name = "website")
    private String website;

    @Column(name = "social_media")
    private String socialMedia;

    @Column(name = "other_social_media")
    private String otherSocialMedia;

    @Column(name = "description")
    private String description;

    @Column(name = "cep")
    private String cep;

    @Column(name = "district")
    private String district;

    public Institution(int id_institution, User id_user, String name, String phone, String whatsapp,
        String email, String cnpj, String street, String city, String state, GeneralStatus status, LocalDateTime createdTime,
        String complement, String website, String socialMedia, String otherSocialMedia, String description, String cep, String district) {

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

    public Institution() {

    }

    public int getId_institution() {
        return this.id_institution;
    }

    public void setId_institution(int id_institution)  {
        this.id_institution = id_institution;
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


    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public User getId_user() {
        return this.id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
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

    public GeneralStatus getStatus() {
        return this.status;
    }

    public void setStatus(GeneralStatus status) {
        this.status = status;
    }

    public Institution withId_Institution(int id_institution) {
        this.id_institution = id_institution;
        return this;
    }

    public Institution withId_user(User id_user) {
        this.id_user = id_user;
        return this;
    }

    public Institution withCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public Institution withName(String name) {
        this.name = name;
        return this;
    }

    public Institution withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Institution withWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        return this;
    }

    public Institution withEmail(String email) {
        this.email = email;
        return this;
    }

    public Institution withStreet(String street) {
        this.street = street;
        return this;
    }

    public Institution withCity(String city) {
        this.city = city;
        return this;
    }

    public Institution withState(String state) {
        this.state = state;
        return this;
    }

    public Institution withStatus(GeneralStatus  status) {
        this.status = status;
        return this;
    }

    public Institution withCreatedTime(LocalDateTime  createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Institution withComplement(String complement) {
        this.complement = complement;
        return this;
    }
    
    public Institution withWebsite(String website) {
        this.website = website;
        return this;
    }

    public Institution withSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
        return this;
    }

    public Institution withOtherSocialMedia(String otherSocialMedia) {
        this.otherSocialMedia = otherSocialMedia;
        return this;
    }

    public Institution withDescription(String description) {
        this.description = description;
        return this;
    }

    public Institution withCep(String cep) {
        this.cep = cep;
        return this;
    }

    public Institution withDistrict(String district) {
        this.district = district;
        return this;
    }
}
