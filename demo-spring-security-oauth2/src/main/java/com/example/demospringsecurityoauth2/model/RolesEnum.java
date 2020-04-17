package com.example.demospringsecurityoauth2.model;

public enum RolesEnum {

    ROLE_ADMIN("ROLE_ADMIN"), ROLE_CLIENT("ROLE_CLIENT");

    private String valor;

    RolesEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
