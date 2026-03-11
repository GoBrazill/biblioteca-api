package biblioteca.com.controllers;

import biblioteca.com.DTOs.EmprestimoDTO;
import biblioteca.com.entities.Emprestimo;
import biblioteca.com.services.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("criar/{id}")
    public ResponseEntity<?> criarEmprestimo(@Valid @RequestBody EmprestimoDTO emprestimoDTO, @PathVariable long id) {
        return ResponseEntity.ok(emprestimoService.criarEmprestimo(emprestimoDTO, id));
    }

    @GetMapping("mostrar/{id}")
    public Optional<Emprestimo> mostrarEmprestimoPorId(@PathVariable long id) {
        return emprestimoService.mostrarEmprestimoPorId(id);
    }

    @PostMapping("atualizar/{id}")
    public ResponseEntity<?> atualizarEmprestimo(@PathVariable long id, @Valid @RequestBody EmprestimoDTO emprestimoDTO) {

        return ResponseEntity.ok(emprestimoService.atualizarEmprestimo(id, emprestimoDTO));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<?> deletarEmprestimoPorId(@PathVariable long id) {

        return ResponseEntity.ok(emprestimoService.deletarEmprestimo(id));
    }

}
