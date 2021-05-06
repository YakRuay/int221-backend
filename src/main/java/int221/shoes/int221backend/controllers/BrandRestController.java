package int221.shoes.int221backend.controllers;

import int221.shoes.int221backend.exception.ApiRequestException;
import int221.shoes.int221backend.models.Brands;
import int221.shoes.int221backend.repositories.BrandJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@CrossOrigin(origins = "*")
public class BrandRestController {
    @Autowired
    private BrandJpaRepository brandJpaRepository;

    @GetMapping("/getall")
    public List<Brands> showAllBrand() {
        return this.brandJpaRepository.findAll();
    }

    @GetMapping("/{brandID}")
    public Brands showBrand(@PathVariable int brandID){
        if(brandJpaRepository.findById(brandID).orElse(null) == null) {
            throw new ApiRequestException("Not Found Brand");
        }
        return this.brandJpaRepository.findById(brandID).orElse(null);
    }


}
