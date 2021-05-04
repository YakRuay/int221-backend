package int221.shoes.int221backend.controllers;

import int221.shoes.int221backend.models.Colors;
import int221.shoes.int221backend.repositories.ColorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ColorsRestController {
    @Autowired
    private ColorJpaRepository colorsJpaRepository;

    @GetMapping("/colors")
    public List<Colors> showAllColors(){
        return this.colorsJpaRepository.findAll();
    }

    @GetMapping("/colors/{colorID}")
    public Colors showColor(@PathVariable int colorID){
        return this.colorsJpaRepository.findById(colorID).orElse(null);
    }
}
