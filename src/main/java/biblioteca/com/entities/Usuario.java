package biblioteca.com.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimos = new ArrayList<>();


    @OneToOne(mappedBy = "carteiraBiblioteca", cascade = CascadeType.ALL)
    private CarteiraBiblioteca carteiraBiblioteca;


    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
