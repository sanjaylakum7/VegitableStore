package CollegeProject.Service;

import CollegeProject.Entities.Product;
import CollegeProject.Models.Product_Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
//    public Product_Model addNewProduct(Product product) throws IOException;

    public List<Product_Model> getAllProducts();

    public Product_Model addNewProduct(MultipartFile file, String name, int price, String description, String storeName) throws IOException;
}
