package montero.antonio.ud2.ej2.repositories;

import montero.antonio.ud2.ej2.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRespository extends JpaRepository<Profesor, Long> {
}
