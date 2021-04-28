package int221.shoes.int221backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int221.shoes.int221backend.models.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
	
}
