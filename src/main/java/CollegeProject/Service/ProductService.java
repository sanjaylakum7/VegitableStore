package CollegeProject.Service;

import CollegeProject.Entities.Product;
import CollegeProject.Models.Product_Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    public Product_Model addNewProduct(Product product, int categoryId);

    public List<Product_Model> getProductByCategoryId(Integer category_id);

}
