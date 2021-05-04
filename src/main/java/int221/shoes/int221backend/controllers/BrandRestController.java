package int221.shoes.int221backend.controllers;

import int221.shoes.int221backend.models.Brands;
import int221.shoes.int221backend.repositories.BrandJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BrandRestController {
    @Autowired
    private BrandJpaRepository brandJpaRepository;

    @GetMapping("/brands")
    public List<Brands> showAllBrand() {
        return this.brandJpaRepository.findAll();
    }

    @GetMapping("/brands/{brandID}")
    public Brands showBrand(@PathVariable int brandID){
        return this.brandJpaRepository.findById(brandID).orElse(null);
    }


}
