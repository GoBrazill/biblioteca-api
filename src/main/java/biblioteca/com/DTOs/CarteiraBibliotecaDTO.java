package biblioteca.com.DTOs;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarteiraBibliotecaDTO {

    @NotBlank
    @FutureOrPresent // Perguntei para a IA se existia uma validação para saber se a data não é menor que a data de hoje
    private Date dataEmissao;
    private boolean isValid;
}
