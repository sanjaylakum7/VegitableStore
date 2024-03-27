package CollegeProject.Service;

import CollegeProject.Entities.Cart;
import CollegeProject.Entities.Customer;
import CollegeProject.Entities.Product;
import CollegeProject.Exception.ResourceNotFoundException;
import CollegeProject.Models.Cart_Model;
import CollegeProject.Repositories.CartRepository;
import CollegeProject.Repositories.CustomerRepository;
import CollegeProject.Repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addProductToCart(Integer customer_id, Integer product_id) {
        Product product = productRepository.findById(product_id).orElseThrow(() -> new ResourceNotFoundException());
        Cart cart = cartRepository.findById(customer_id).orElseThrow(()-> new ResourceNotFoundException());
        Customer customer = customerRepository.findById(customer_id).orElseThrow(()-> new ResourceNotFoundException());
        int increase_Price = cart.getTotal_price() + product.getPrice();
        cart.setTotal_price(increase_Price);
        List<Product> productList = cart.getProducts();
        productList.add(product);
        cart.setCustomer(customer);
        cartRepository.save(cart);
        return "Product Added !!";
    }

    @Override
    public Cart_Model getAllProductFromCart(Integer cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        return modelMapper.map(cart, Cart_Model.class);
    }
}
