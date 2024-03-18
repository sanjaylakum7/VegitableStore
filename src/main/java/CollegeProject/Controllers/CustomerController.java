package CollegeProject.Controllers;

import CollegeProject.Entities.Customer;
import CollegeProject.Models.Customer_Model;
import CollegeProject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // register Customer
    @PostMapping("customer/register")
    public ResponseEntity<Customer_Model> registerCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.registerCustomer(customer), HttpStatus.CREATED);
    }

    // Login Customer
    // update Customer Details
    @PostMapping("customer/{customer_id}")
    public ResponseEntity<Customer_Model> updateCustomer(@RequestBody Customer customer, @PathVariable("customer_id") Integer customerid){
        return new ResponseEntity<>(customerService.updateCustomerDetails(customer, customerid), HttpStatus.OK);
    }

    // Change Password

    // get Customers Details
    @GetMapping("customer/{customer_id}")
    public ResponseEntity<Customer_Model> getParticularCustomer(@PathVariable("customer_id") Integer customerid){
        return new ResponseEntity<>(customerService.getParticularCustomerDetails(customerid), HttpStatus.OK);
    }

    // delete Customer
    @GetMapping("customer/{customer_id}/delete")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customer_id") Integer customerid){
        return new ResponseEntity<>(customerService.deleteCustomer(customerid), HttpStatus.OK);
    }
}
