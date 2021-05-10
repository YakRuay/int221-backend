package int221.shoes.int221backend.repositories;

import int221.shoes.int221backend.models.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandJpaRepository extends JpaRepository<Brands, Integer> {


}
