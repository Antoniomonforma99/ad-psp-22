package montero.antonio.ud2.ej1.repositories;

import montero.antonio.ud2.ej1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
