package CollegeProject.Controllers;

import CollegeProject.Entities.Cart;
import CollegeProject.Models.Cart_Model;
import CollegeProject.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("customer/{customer_id}/product/{product_id}")
    public ResponseEntity<String> addProductToCart(@PathVariable("customer_id") Integer customer_id, @PathVariable("product_id") Integer product_id){
        return new ResponseEntity<>(cartService.addProductToCart(customer_id, product_id), HttpStatus.OK);
    }

    @GetMapping("cart/{cart_id}")
    public ResponseEntity<Cart_Model> getAllProductFromCart(@PathVariable("cart_id") Integer cart_id){
        return new ResponseEntity<>(cartService.getAllProductFromCart(cart_id), HttpStatus.OK);
    }
}
