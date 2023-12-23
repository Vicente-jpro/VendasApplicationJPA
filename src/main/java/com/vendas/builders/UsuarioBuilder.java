package com.vendas.builders;

import org.springframework.stereotype.Component;

import com.vendas.dto.UsuarioDto;
import com.vendas.models.Usuario;

@Component
public class UsuarioBuilder {

    public Usuario toModel(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .id(usuarioDto.getId())
                .username(usuarioDto.getUsername())
                .senha(usuarioDto.getSenha())
                .admin(usuarioDto.isAdmin())
                .build();
    }

    public UsuarioDto toDto(Usuario usuario) {
        return UsuarioDto.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .senha(usuario.getSenha())
                .admin(usuario.isAdmin())
                .build();
    }
}
