package CollegeProject.Models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product_Model {
    private Long id;
    private String images;
    private String name;
    private int price;
    private String description;
    private String store_name;
    private List<Testimonials_Model> testimonials;
}
