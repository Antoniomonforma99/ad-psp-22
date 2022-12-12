package montero.antonio.ud2.ej2.repositories;

import montero.antonio.ud2.ej2.models.CursoOnline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoOnline, Long> {
}
