package com.ages.doacaobackend.business.enums;

public enum GeneralStatus {
    A("A","Ativo"),
    I("I", "Inativo"),
    P("P", "Pendente");

    private final String codigo;
    private final String status;

    GeneralStatus(String codigo, String status){
        this.codigo = codigo;
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }
}
