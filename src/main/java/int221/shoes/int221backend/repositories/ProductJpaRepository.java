package int221.shoes.int221backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int221.shoes.int221backend.models.Products;

public interface ProductJpaRepository extends JpaRepository<Products, Integer> {
	
}
