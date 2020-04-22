package com.example.demospringsecuritydb.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public UsuarioSistema(String nome, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}