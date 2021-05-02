package int221.shoes.int221backend.controllers;

import java.util.List;

import int221.shoes.int221backend.models.Brands;
import int221.shoes.int221backend.repositories.BrandJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int221.shoes.int221backend.models.Products;
import int221.shoes.int221backend.repositories.ProductJpaRepository;

@RestController
@CrossOrigin("*")
public class ProductRestController {
	@Autowired
	private ProductJpaRepository productJpaRepository;
	@Autowired
	private BrandJpaRepository brandJpaRepository;

	@GetMapping("/health")
	public List<Products> show() {
		return productJpaRepository.findAll();
	}

	@GetMapping("/getall")
	public List<Brands> showBrand() { return brandJpaRepository.findAll(); }
}
