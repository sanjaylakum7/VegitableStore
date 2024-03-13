package CollegeProject.Service;

import CollegeProject.Entities.Address;
import CollegeProject.Models.Address_Model;

import java.util.List;

public interface AddressService {
    public Address_Model createNewAddress(Address address, int customerId);

    String deleteAddress(int customer_id, int address_id);

    Address_Model updateCustomerAddress(Address address, int customerId, int addressId);

    Address_Model getACustomerAddress(int customerId, int addressId);

    List<Address_Model> getAllCustomerAddress(int customerId);
}
