package CollegeProject.Service;

import CollegeProject.Entities.Customer;
import CollegeProject.Entities.Product;
import CollegeProject.Entities.WishList;
import CollegeProject.Exception.ResourceNotFoundException;
import CollegeProject.Models.Wishlist_Model;
import CollegeProject.Repositories.CustomerRepository;
import CollegeProject.Repositories.ProductRepository;
import CollegeProject.Repositories.WishlistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.stream.Collectors;

@Service
public class WishlistServiceImpl implements WishlistService{

    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addProductToWishlist(Integer customer_id, Integer product_id) {
        Customer customer = customerRepository.findById(customer_id).orElseThrow(()-> new ResourceNotFoundException());
        Product product = productRepository.findById(product_id).orElseThrow(()-> new ResourceNotFoundException());

        WishList wishList = wishlistRepository.findById(customer_id).orElseThrow(() -> new ResourceNotFoundException());
        if(wishList != null){
            List<Product> productList = wishList.getProductList();
            productList.add(product);
            wishList.setProductList(productList);
            wishList.setCustomer(customer);
            wishlistRepository.save(wishList);
        }else{
            return "wishlist is not created !!";
        }
        return "Product is added to the wishlist !!";
    }

    @Override
    public List<Wishlist_Model> getAllWishlist(Integer customer_id) {
        List<WishList> wishLists = wishlistRepository.findByCustomerId(customer_id);
        return wishLists.stream().map(wish -> modelMapper.map(wish, Wishlist_Model.class)).collect(Collectors.toList());
    }
}
