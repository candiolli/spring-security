package com.example.demospringsecuritydb.repository;

import com.example.demospringsecuritydb.model.Grupo;
import com.example.demospringsecuritydb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
	List<Grupo> findByUsuariosIn(List<Usuario> usuario);

}
