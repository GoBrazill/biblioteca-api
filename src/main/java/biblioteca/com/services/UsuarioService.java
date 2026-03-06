package biblioteca.com.services;

import biblioteca.com.DTOs.UsuarioDTO;
import biblioteca.com.entities.Usuario;
import biblioteca.com.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO criarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail());
        usuarioRepository.save(usuario);
        UsuarioDTO usuarioDto = new UsuarioDTO(usuario.getNome(), usuario.getEmail());
        return usuarioDto;
    }

    public UsuarioDTO mostrarUsuarioPorIs() {

        return new UsuarioDTO();
    }
}
