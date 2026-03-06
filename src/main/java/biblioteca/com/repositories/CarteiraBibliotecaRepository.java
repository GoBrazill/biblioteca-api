package biblioteca.com.repositories;

import biblioteca.com.entities.CarteiraBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraBibliotecaRepository extends JpaRepository<CarteiraBiblioteca, Long> {
}
