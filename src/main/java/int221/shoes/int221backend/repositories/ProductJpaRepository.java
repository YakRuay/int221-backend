package int221.shoes.int221backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int221.shoes.int221backend.models.Products;

import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<Products, Integer> {
    Optional<Products> findTopByOrderByProductIDProductDesc();
}
