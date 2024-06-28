package com.ages.doacaobackend.controller.handler.logMessages;

public abstract class ErrorMessages {

    public static final String EXISTING_ENTITY = "Entity with id %s already exists in the database";
    public static final String ENTITY_NOT_FOUND = "Entity with id %s not found in the database";
    public static final String EXISTING_CNPJ = "Institution with CNPJ %s already exists in the database";
    public static final String ITEM_LIMIT_LESS_ONE = "Item Limit value %s is less than 1";
    public static final String EXISTING_USER = "User already registered with the %s e-mail";
}
