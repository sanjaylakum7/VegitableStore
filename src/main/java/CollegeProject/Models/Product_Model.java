package CollegeProject.Models;

import CollegeProject.Entities.Category;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product_Model {
    private Long id;
    private MultipartFile images;
    private String name;
    private int price;
    private String description;
    private String store_name;
    private List<Testimonials_Model> testimonials;
}
