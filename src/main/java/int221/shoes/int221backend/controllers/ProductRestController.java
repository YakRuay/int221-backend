package int221.shoes.int221backend.controllers;

import java.util.List;

import int221.shoes.int221backend.exception.ApiRequestException;
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

	@GetMapping("/{productID}")
	public Products showProduct(@PathVariable int productID){
		try {
			return this.productJpaRepository.findById(productID).orElse(null);
		} catch (Exception e) {
			throw new ApiRequestException("Not Found Product");
		}

	}

	@PostMapping("/add")
	public Products newProduct(@RequestBody Products newProduct){
		productJpaRepository.save(newProduct);
		return newProduct;
	}

	@PutMapping("/{productID}")
	public Products updateProduct(@RequestBody Products updateProduct, @PathVariable int productID) {
			if(productJpaRepository.findById(productID).orElse(null) == null) {
				throw new ApiRequestException("Not Found Product");
			}
			return productJpaRepository.findById(productID)
					.map(product -> {
						product.setProductName(updateProduct.getProductName());
						product.setProductDetail(updateProduct.getProductDetail());
						product.setProductReleaseDate(updateProduct.getProductReleaseDate());
						product.setProductPrice(updateProduct.getProductPrice());
						product.setBrandID(updateProduct.getBrandID());
						product.setColors(updateProduct.getColors());
						return productJpaRepository.save(updateProduct);
					})
					.orElseGet(() -> productJpaRepository.save(updateProduct));
	}

	@DeleteMapping("/{productID}")
	public String deleteProduct(@PathVariable int productID){
		if(productJpaRepository.findById(productID).orElse(null) == null){
			throw new ApiRequestException("Not Found Product");
		}
		productJpaRepository.deleteById(productID);
		return "null";
	}

}
