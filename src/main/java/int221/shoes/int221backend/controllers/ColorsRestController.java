package int221.shoes.int221backend.controllers;

import int221.shoes.int221backend.models.Colors;
import int221.shoes.int221backend.repositories.ColorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
@CrossOrigin(origins = "*")
public class ColorsRestController {
    @Autowired
    private ColorJpaRepository colorsJpaRepository;

    @GetMapping("/getall")
    public List<Colors> showAllColors(){
        return this.colorsJpaRepository.findAll();
    }

    @GetMapping("/{colorID}")
    public Colors showColor(@PathVariable int colorID){
        return this.colorsJpaRepository.findById(colorID).orElse(null);
    }
}
