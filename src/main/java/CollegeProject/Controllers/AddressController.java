package CollegeProject.Controllers;

import CollegeProject.Entities.Address;
import CollegeProject.Exception.ResourceNotFoundException;
import CollegeProject.Models.Address_Model;
import CollegeProject.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // create Address
    @PostMapping("public/customer/{customer_id}/address")
    public ResponseEntity<Address_Model> createNewAddress(@RequestBody Address address, @PathVariable("customer_id") int customer_id){
        return new ResponseEntity<>(addressService.createNewAddress(address, customer_id), HttpStatus.CREATED);
    }

    // delete address
    @DeleteMapping("public/customer/{customer_id}/address/{address_id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("customer_id") int customer_id, @PathVariable("address_id") int address_id){
        return new ResponseEntity<>(addressService.deleteAddress(customer_id, address_id), HttpStatus.OK);
    }

    // update address
    @PostMapping("public/customer/{customer_id}/address/{address_id}")
    public ResponseEntity<Address_Model> updateCustomerAddress(@RequestBody Address address, @PathVariable("customer_id") int customer_id, @PathVariable("address_id") int address_id){
        Address_Model addressModel = addressService.updateCustomerAddress(address, customer_id, address_id);
        if(addressModel == null) throw new ResourceNotFoundException();
        return ResponseEntity.ok(addressModel);
    }

    // Get a address
    @GetMapping("public/customer/{customer_id}/address/{address_id}")
    public ResponseEntity<Address_Model> getACustomerAddress(@PathVariable("customer_id") int customer_id, @PathVariable("address_id") int address_id){
        return new ResponseEntity<>(addressService.getACustomerAddress(customer_id, address_id), HttpStatus.OK);
    }

    // Get all address Based on customer
    @GetMapping("public/customer/{customer_id}/addresses")
    public ResponseEntity<List<Address_Model>> getACustomerAddress(@PathVariable("customer_id") int customer_id){
        return new ResponseEntity<>(addressService.getAllCustomerAddress(customer_id), HttpStatus.OK);
    }
}
