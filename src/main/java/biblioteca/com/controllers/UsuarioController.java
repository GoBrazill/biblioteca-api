package biblioteca.com.controllers;

import biblioteca.com.DTOs.UsuarioDTO;
import biblioteca.com.entities.Usuario;
import biblioteca.com.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("criar")
    public ResponseEntity<?> criarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.criarUsuario(usuarioDTO));
    }

    @GetMapping("mostrar/{id}")
    public Optional<Usuario> mostrarEmprestimoPorId(@PathVariable long id) {
        return usuarioService.mostrarUsuarioPorID(id);
    }

    @PostMapping("atualizar/{id}")
    public ResponseEntity<?> atualizarEmprestimo(@PathVariable long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {

        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, usuarioDTO));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<?> deletarEmprestimoPorId(@PathVariable long id) {

        return ResponseEntity.ok(usuarioService.deletarUsuario(id));
    }
}
