package CollegeProject.Service;

import CollegeProject.Models.Wishlist_Model;

import java.util.*;

public interface WishlistService {
    public String addProductToWishlist(Integer customer_id, Integer product_id);
    public List<Wishlist_Model> getAllWishlist(Integer customer_id);
}
