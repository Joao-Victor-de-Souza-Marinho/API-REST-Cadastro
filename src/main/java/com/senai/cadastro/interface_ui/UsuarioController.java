package com.senai.cadastro.interface_ui;

import com.senai.cadastro.application.dto.UsuarioRequestDTO;
import com.senai.cadastro.application.service.UsuarioService;
import com.senai.cadastro.domain.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable UUID id) {
      return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.save(usuarioRequestDTO.toEntity());
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable UUID id, @RequestBody Usuario usuario) {
        return usuarioService.update(usuario,id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable UUID id) {
        usuarioService.deleteById(id);
    }
}