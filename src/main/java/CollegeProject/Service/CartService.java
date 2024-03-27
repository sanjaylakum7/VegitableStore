package CollegeProject.Service;

import CollegeProject.Entities.Cart;
import CollegeProject.Models.Cart_Model;

public interface CartService {
    public String addProductToCart(Integer customer_id, Integer product_id);

		public Cart_Model getAllProductFromCart(Integer cartId);
}
