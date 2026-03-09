package biblioteca.com.services;

import biblioteca.com.DTOs.CarteiraBibliotecaDTO;
import biblioteca.com.DTOs.UsuarioDTO;
import biblioteca.com.entities.CarteiraBiblioteca;
import biblioteca.com.entities.Usuario;
import biblioteca.com.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CarteiraBibliotecaService carteiraBibliotecaService;

    public UsuarioService(UsuarioRepository usuarioRepository, CarteiraBibliotecaService carteiraBibliotecaService) {
        this.usuarioRepository = usuarioRepository;
        this.carteiraBibliotecaService = carteiraBibliotecaService;
    }


    public UsuarioDTO criarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail());
        usuarioRepository.save(usuario);

        CarteiraBibliotecaDTO carteiraBibliotecaDTO = new CarteiraBibliotecaDTO();
//        Tive que perguntar a IA como usar o método .now em Date e ela falou que não existe e rcomendou isso
        carteiraBibliotecaDTO.setDataEmissao(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        carteiraBibliotecaDTO.setValid(true);
//        Não sei como pegar o id do usuário para setar a chave estrangeira na carteiraBiblioteca
//        carteiraBibliotecaService.criarCarteiraBiblioteca(carteiraBibliotecaDTO);

        UsuarioDTO usuarioDto = new UsuarioDTO(usuario.getNome(), usuario.getEmail());
        return usuarioDto;
    }

    public Optional<Usuario> mostrarUsuarioPorID(long id) {
        return usuarioRepository.findById(id);
    }

    public String atualizarUsuario(long id, UsuarioDTO alteracoes) {
        Optional<Usuario> usuarioExiste = usuarioRepository.findById(id);

        if (usuarioExiste.isPresent()) {
            Usuario usuario = usuarioExiste.get();
            usuario.setNome(alteracoes.getNome());
            usuario.setEmail(alteracoes.getEmail());
            usuarioRepository.save(usuario);
            return "Nome e senha alterados com sucesso" + "\n id: " + usuario.getId() + "\n name: " + usuario.getNome() + "\n email: " + usuario.getEmail();
        } else {
            return "Usuário não encontrado";
        }
    }

    public String deletarUsuario(long id) {
        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return "Usuário excluído com sucesso";
        } else {
            return "Usuário não encontrado";
        }
    }
}
