package com.example.demospringsecuritydb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String login;

    private String senha;

    private boolean ativo;

    @ManyToMany
    private List<Grupo> grupos;

    @ManyToMany
    private List<Permissao> permissoes;
}
