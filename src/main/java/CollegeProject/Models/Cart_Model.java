package CollegeProject.Models;

import CollegeProject.Entities.Customer;
import CollegeProject.Entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart_Model {
		private Customer_Model customer;
		private List<Product_Model> products;
		private int total_price;
}
