package int221.shoes.int221backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int221.shoes.int221backend.models.Product;
import int221.shoes.int221backend.repositories.ProductJpaRepository;

@RestController
@CrossOrigin("*")
public class ProductRestController {
	@Autowired
	private ProductJpaRepository productJpaRepository;
	
	@GetMapping("/health")
	public List<Product> show() {
		return productJpaRepository.findAll();
	}
}
