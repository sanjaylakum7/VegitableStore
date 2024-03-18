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
@RequestMapping("admin/")
public class ProductController {

    @Autowired
    private ProductService productService;

    // create a product
    @PostMapping("category/{category_id}/product")
    public ResponseEntity<Product_Model> createNewProduct(@RequestBody Product product,
                                                          @PathVariable("category_id") int category_id) throws IOException {
        return new ResponseEntity<>(productService.addNewProduct(product, category_id), HttpStatus.CREATED);
    }

    // get Product by category
    @GetMapping("category/{category_id}/product")
    public ResponseEntity<List<Product_Model>> getProductByCategory(@PathVariable("category_id") Integer category_id) {
        return new ResponseEntity<>(productService.getProductByCategoryId(category_id), HttpStatus.OK);
    }
}
