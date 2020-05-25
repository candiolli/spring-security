package com.example.springsecurity.repository;

import com.example.springsecurity.model.Grupo;
import com.example.springsecurity.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
	List<Grupo> findByUsuariosIn(List<Usuario> usuario);

}
