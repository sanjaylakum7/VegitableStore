package CollegeProject.Service;

import CollegeProject.Entities.Product;
import CollegeProject.Exception.ResourceNotFoundException;
import CollegeProject.Models.Product_Model;
import CollegeProject.Repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepository;

    @Value("${project.image}")
    private String path;

//    @Override
//    public Product_Model addNewProduct(Product product) throws IOException {
//        return modelMapper.map(productRepository.save(product), Product_Model.class);
//    }

    @Override
    public List<Product_Model> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> modelMapper.map(product, Product_Model.class)).collect(Collectors.toList());
    }

    @Override
    public Product_Model addNewProduct(MultipartFile file, String name, int price, String description, String storeName) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setStore_name(storeName);
        product.setDescription(description);
        product.setPrice(price);

        // Add image
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(path, fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        product.setImages(filePath.toString());

        return modelMapper.map(productRepository.save(product), Product_Model.class);
    }

}
