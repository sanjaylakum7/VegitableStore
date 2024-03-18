package CollegeProject.Service;

import CollegeProject.Entities.Category;
import CollegeProject.Entities.Product;
import CollegeProject.Exception.ResourceNotFoundException;
import CollegeProject.Models.Product_Model;
import CollegeProject.Repositories.CategoryRepository;
import CollegeProject.Repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepository;

    @Value("${project.image}")
    private String path;

    @Override
    public Product_Model addNewProduct(Product product, int categoryId) throws IOException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException());
        product.setCategory(category);

//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//        File newFile = new File(path);
//        if(!newFile.exists()) newFile.mkdir();
//        Path filePath = Paths.get(path, fileName);
//        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//        product.setImages(filePath.toString());

        return modelMapper.map(productRepository.save(product), Product_Model.class);
    }

    @Override
    public List<Product_Model> getProductByCategoryId(Integer category_id) {
        List<Product> productList = productRepository.findByCategoryId(category_id).orElseThrow(() -> new ResourceNotFoundException());
        return productList.stream().map(product -> modelMapper.map(product, Product_Model.class)).collect(Collectors.toList());
    }

}
