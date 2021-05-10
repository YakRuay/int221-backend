package int221.shoes.int221backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int221.shoes.int221backend.models.Products;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface  ProductJpaRepository extends JpaRepository<Products, Integer> {
    @Query("select max(productID) from Products")
    Optional<Products> findProductsByProductIDOrderByProductIDDesc();
}
