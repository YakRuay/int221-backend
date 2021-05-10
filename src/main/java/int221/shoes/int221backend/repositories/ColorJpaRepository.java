package int221.shoes.int221backend.repositories;

import int221.shoes.int221backend.models.Colors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorJpaRepository extends JpaRepository<Colors, Integer> {
}
