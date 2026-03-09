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
    @FutureOrPresent
    private Date dataEmissao;
    private boolean isValid;
}
