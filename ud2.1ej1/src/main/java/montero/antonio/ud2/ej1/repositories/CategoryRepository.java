package montero.antonio.ud2.ej1.repositories;

import montero.antonio.ud2.ej1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
