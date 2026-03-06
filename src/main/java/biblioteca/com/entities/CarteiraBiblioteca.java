package biblioteca.com.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarteiraBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroCarteira;
    private Date dataEmissao;
    private boolean isValid;

    @OneToOne
    @MapsId
    private Usuario usuario;
}
