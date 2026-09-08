package com.senai.cadastro.application.service;

import com.senai.cadastro.application.dto.UsuarioRequestDTO;
import com.senai.cadastro.application.dto.UsuarioResponseDTO;
import com.senai.cadastro.domain.entity.Usuario;
import com.senai.cadastro.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    final UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioResponseDTO::fromEntity).toList();
    }

    public Usuario findById(UUID id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if(usuarioOpt.isPresent()) {
            return  usuarioOpt.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO) {
        return UsuarioResponseDTO.fromEntity(
                usuarioRepository.save(usuarioRequestDTO.toEntity())
        );

    }

    public UsuarioResponseDTO update(UsuarioRequestDTO usuarioRequestDTO, UUID id) {

       Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));


        usuarioExistente.setNome(usuarioRequestDTO.nome());
        usuarioExistente.setCpf(usuarioRequestDTO.cpf());
        usuarioExistente.setEmail(usuarioRequestDTO.email());
        usuarioExistente.setSenha(usuarioRequestDTO.senha());

        return UsuarioResponseDTO.fromEntity(
                usuarioRepository.save(usuarioExistente)
        );
    }

    public void delete(UUID id) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

    }
}
