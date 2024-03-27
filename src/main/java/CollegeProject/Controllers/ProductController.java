package CollegeProject.Controllers;

import CollegeProject.Entities.Product;
import CollegeProject.Models.Product_Model;
import CollegeProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // create a product
    @PostMapping("product")
    public ResponseEntity<Product_Model> createNewProduct(@RequestParam("images") MultipartFile file,
                                                          @RequestParam("name") String name,
                                                          @RequestParam("price") int price,
                                                          @RequestParam("description") String description,
                                                          @RequestParam("store_name") String store_name
                                                          ) throws IOException {
        return new ResponseEntity<>(productService.addNewProduct(file, name, price, description, store_name),
                HttpStatus.CREATED);
    }

    // get Product by category
    @GetMapping("products")
    public ResponseEntity<List<Product_Model>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
