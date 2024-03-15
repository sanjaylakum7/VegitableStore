package CollegeProject.Service;

import CollegeProject.Entities.Cart;
import CollegeProject.Entities.Customer;
import CollegeProject.Entities.WishList;
import CollegeProject.Exception.ResourceNotFoundException;
import CollegeProject.Models.Customer_Model;
import CollegeProject.Repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerServiceImpl implements  CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Customer_Model registerCustomer(Customer customer) {
        customer.setAddress(new ArrayList<>());
        customer.setWishList(new WishList());
        customer.setCart(new Cart());
        return modelMapper.map(customerRepository.save(customer), Customer_Model.class);
    }

    @Override
    public Customer_Model updateCustomerDetails(Customer customer, Integer customerId) {
        Customer existCustomer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException());

        existCustomer.setLastname(customer.getLastname());
        existCustomer.setFirstname(customer.getFirstname());
        existCustomer.setPhoneNo(customer.getPhoneNo());
        existCustomer.setEmailId(customer.getEmailId());

        return modelMapper.map(customerRepository.save(existCustomer), Customer_Model.class);
    }

    @Override
    public Customer_Model getParticularCustomerDetails(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException());
        Customer_Model customerModel = modelMapper.map(customer, Customer_Model.class);
        return customerModel;
    }

    @Override
    public String deleteCustomer(Integer customerId) {
        Customer existCustomer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException());
        customerRepository.delete(existCustomer);
        return "Customer successfully deleted !!";
    }

}
