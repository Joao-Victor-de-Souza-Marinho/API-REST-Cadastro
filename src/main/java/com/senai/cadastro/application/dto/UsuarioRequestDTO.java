package com.senai.cadastro.application.dto;

import com.senai.cadastro.domain.entity.Usuario;


public record UsuarioRequestDTO(
        
        String nome,
        String cpf,
        String email,
        String senha
) {

    public Usuario toEntity() {
        return new Usuario(
                id:null,
                dto.nome,
                dto.cpf,
                dto.email,
                dto.senha
            );
    }
}

