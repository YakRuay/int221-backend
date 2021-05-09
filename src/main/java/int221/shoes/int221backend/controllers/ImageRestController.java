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
import java.rmi.RemoteException;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/images")
@CrossOrigin("*")
public class ImageRestController {
    @Autowired
    private ProductJpaRepository productJpaRepository;
    private static final String IMAGE_PATH = "./src/images/";

    @GetMapping("/get/{productID}")
    public ResponseEntity<byte[]> getImage(@PathVariable String productID) throws IOException {
        try {
            FileInputStream file = new FileInputStream(IMAGE_PATH + productID);
            byte[] image = file.readAllBytes();
            file.close();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
        } catch(Exception e) {
            throw new RemoteException("Image not Found");
        }

    }

    @PostMapping ("/add/{productID}")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable String productID) {
        try {
            File myFile = new File(IMAGE_PATH + productID);
            myFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(myFile);
            fos.write(file.getBytes());
            fos.close();
            return  new ResponseEntity<>("The File Uploaded Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/edit/{imageName}")
    public ResponseEntity<Object> changeImage(@RequestParam MultipartFile file, @PathVariable String imageName) {
        try {
            String productIDString[] = imageName.split("\\.(?=[^\\.]+$)");
            int hasId = parseInt(productIDString[0]);
            if(hasFoundId(hasId)){
                FileOutputStream fos = new FileOutputStream(IMAGE_PATH + imageName);
                fos.write(file.getBytes());
                fos.close();
                return  new ResponseEntity<>("The File Change Successfully", HttpStatus.OK);
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/delete/{productID}")
    public ResponseEntity<Object> deleteImage(@PathVariable String productID){
        try {
                File myFile = new File(IMAGE_PATH + productID);
                myFile.delete();
                return  new ResponseEntity<>("The Delete Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean hasFoundId(int productID){
            List<Products> products = productJpaRepository.findAll();
            if(products.isEmpty()){
                return false;
            }
            for (int i = 0; i < products.size(); i++) {
                    if(products.get(i).getProductID() == productID){
                        return true;
                    }
                }
        return false;
    }
}
