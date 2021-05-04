package int221.shoes.int221backend.controllers;

import java.util.List;

import int221.shoes.int221backend.models.Brands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import int221.shoes.int221backend.models.Products;
import int221.shoes.int221backend.repositories.ProductJpaRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductRestController {
	@Autowired
	private ProductJpaRepository productJpaRepository;

	@GetMapping("/getall")
	public List<Products> showAllProduct() {
		return productJpaRepository.findAll();
	}

	@GetMapping("/get/{productID}")
	public Products showProduct(@PathVariable int productID){
		return this.productJpaRepository.findById(productID).orElse(null);
	}

	@PostMapping("/add")
	public Products newProduct(@RequestBody Products newProduct){
		productJpaRepository.save(newProduct);
		return newProduct;
	}

}
