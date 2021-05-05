package int221.shoes.int221backend.controllers;

import int221.shoes.int221backend.models.Products;
import int221.shoes.int221backend.repositories.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/images")
@CrossOrigin("*")
public class ImageRestController {
    @Autowired
    private ProductJpaRepository productJpaRepository;
    private static final String IMAGE_PATH = "./src/images/";

    @GetMapping("/get/{productID:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable String productID) throws IOException {
        FileInputStream fi = new FileInputStream(IMAGE_PATH + productID);
        byte[] image = fi.readAllBytes();
        fi.close();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
    }

    @PostMapping ("/add/{productID}")
    public ResponseEntity<Object> fileUpload(@RequestParam MultipartFile file, @PathVariable String productID)throws IOException{
        System.out.println(file.getContentType());
        File myFile = new File(IMAGE_PATH + productID + MediaType.IMAGE_PNG);
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return  new ResponseEntity<>("The File Uploaded Successfully", HttpStatus.OK);
    }

    @PutMapping("/edit/{productID:.+}")
    public void changeImage(@RequestParam("File")MultipartFile file, @PathVariable String productID) throws IOException {
        FileOutputStream fos = new FileOutputStream(IMAGE_PATH + productID);
        fos.write(file.getBytes());
        fos.close();
    }

    @DeleteMapping("/delete/{productID:.+}")
    public void deleteImage(@PathVariable String productID){
        String IdString[] = productID.split("\\.(?=[^\\.]+$)");
        int hasId = parseInt(IdString[0]);
        if (hasFoundId(hasId)){
            File myFile = new File(IMAGE_PATH + productID);
            myFile.delete();
        }
    }

    public boolean hasFoundId(int productID){
        List<Products> products = productJpaRepository.findAll();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductID() == productID){
                return true;
            }
        }
        return false;
    }


}
