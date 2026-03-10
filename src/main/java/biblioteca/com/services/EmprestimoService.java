package biblioteca.com.services;

import biblioteca.com.DTOs.EmprestimoDTO;
import biblioteca.com.entities.Emprestimo;
import biblioteca.com.entities.Usuario;
import biblioteca.com.repositories.EmprestimoRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public EmprestimoDTO criarEmprestimo(EmprestimoDTO dto, Usuario usuario) {
        Emprestimo emprestimo = new Emprestimo(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), dto.getDataDevolucao());
        emprestimoRepository.save(emprestimo);

        EmprestimoDTO emprestimoDTO = new EmprestimoDTO(emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao());
        return emprestimoDTO;
    }

    public Optional<Emprestimo> mostrarEmprestimoPorId(long id) {
        return emprestimoRepository.findById(id);
    }

    public String atualizarEmprestimo(long id, EmprestimoDTO alteracoes) {
        Optional<Emprestimo> emprestimoExiste = emprestimoRepository.findById(id);

        if (emprestimoExiste.isPresent()) {
            Emprestimo emprestimo = emprestimoExiste.get();
            emprestimo.setDataDevolucao(alteracoes.getDataDevolucao());
            emprestimoRepository.save(emprestimo);

            return "Data de devolução alterada com sucesso para: " + emprestimo.getDataDevolucao();
        } else {
            return "Empréstimo não encontrado";
        }
    }

    public String deletarEmprestimo(long id) {
        if (emprestimoRepository.existsById(id)) {
            emprestimoRepository.deleteById(id);
            return "Empréstimo deletado com sucesso";
        } else {
            return "Empréstimo não encontrado";
        }
    }
}
