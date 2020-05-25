package com.example.springsecurity.repository;

import com.example.springsecurity.model.Grupo;
import com.example.springsecurity.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByGruposIn(List<Grupo> grupo);

}
