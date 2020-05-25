package com.example.springsecurity.security;

import com.example.springsecurity.model.Grupo;
import com.example.springsecurity.model.Permissao;
import com.example.springsecurity.model.Usuario;
import com.example.springsecurity.repository.GrupoRepository;
import com.example.springsecurity.repository.PermissaoRepository;
import com.example.springsecurity.repository.UsuarioRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarios;

    @Autowired
    private GrupoRepository grupos;

    @Autowired
    private PermissaoRepository permissoes;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarios.findByLogin(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), authorities(usuario));
    }

    public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
        return authorities(grupos.findByUsuariosIn(Lists.newArrayList(usuario)));
    }

    public Collection<? extends GrantedAuthority> authorities(List<Grupo> grupos) {
        Collection<GrantedAuthority> auths = new ArrayList<>();

        for (Grupo grupo: grupos) {
            List<Permissao> lista = permissoes.findByGruposIn(Lists.newArrayList(grupo));

            for (Permissao permissao: lista) {
                auths.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
            }
        }

        return auths;
    }

}