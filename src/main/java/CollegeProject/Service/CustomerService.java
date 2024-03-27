package CollegeProject.Service;

import CollegeProject.Entities.Customer;
import CollegeProject.Models.Customer_Model;

import java.util.List;

public interface CustomerService {
    public Customer_Model registerCustomer(Customer customer);
    public Customer_Model updateCustomerDetails(Customer customer, Integer customerId);
    public Customer_Model getParticularCustomerDetails(Integer customerId);
    public String deleteCustomer(Integer customerId);
    public Boolean login(String emailId, String password);
		public List<Customer_Model> getAllCustomer();
}
