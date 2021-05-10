package int221.shoes.int221backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
		if(productJpaRepository.findById(productID).orElse(null) == null){
			throw new ApiRequestException("Not Found Product");
		}
			return this.productJpaRepository.findById(productID).orElse(null);
	}

	@GetMapping("/last")
	public List<Products> getLastProducts(){
		return productJpaRepository.findProductsByProductIDOrderByProductIDDesc().stream().collect(Collectors.toList());
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
	public void deleteProduct(@PathVariable int productID){
		try{
			if(productJpaRepository.findById(productID).orElse(null) == null){
				throw new ApiRequestException("Not Found Product");
			}
			productJpaRepository.deleteById(productID);
			ImageRestController imgRest = new ImageRestController();
			imgRest.deleteImage(Integer.toString(productID));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
