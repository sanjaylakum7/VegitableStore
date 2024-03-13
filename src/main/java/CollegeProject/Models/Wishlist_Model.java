package CollegeProject.Models;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist_Model {
    private Integer wishlist_id;

    private Customer_Model customer;

    private List<Product_Model> productList;
}
