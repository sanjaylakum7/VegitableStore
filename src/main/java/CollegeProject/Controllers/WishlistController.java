package CollegeProject.Controllers;

import CollegeProject.Entities.WishList;
import CollegeProject.Models.Wishlist_Model;
import CollegeProject.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("public/customer/{customer_id}/product/{product_id}")
    public ResponseEntity<String> addProductToWishlist(@PathVariable("customer_id") Integer customer_id, @PathVariable("product_id") Integer product_id){
        return new ResponseEntity<>(wishlistService.addProductToWishlist(customer_id, product_id), HttpStatus.OK);
    }

    @GetMapping("public/customer/{customer_id}/wishlist")
    public ResponseEntity<List<Wishlist_Model>> getAllWishlists(@PathVariable("customer_id") Integer customer_id){
        return new ResponseEntity<>(wishlistService.getAllWishlist(customer_id), HttpStatus.OK);
    }
}