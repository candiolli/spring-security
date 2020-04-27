package com.example.demospringsecuritydb.repository;

import com.example.demospringsecuritydb.model.Grupo;
import com.example.demospringsecuritydb.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByGruposIn(List<Grupo> grupo);

}
