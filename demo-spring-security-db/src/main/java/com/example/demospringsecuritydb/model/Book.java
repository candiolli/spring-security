package com.example.demospringsecuritydb.model;

import java.math.BigDecimal;

public class Book {

    private String descricao;
    private BigDecimal valor;

    public Book() {}

    public Book(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
