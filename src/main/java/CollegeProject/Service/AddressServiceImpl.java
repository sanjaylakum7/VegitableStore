package CollegeProject.Service;

import CollegeProject.Entities.Address;
import CollegeProject.Entities.Customer;
import CollegeProject.Exception.ResourceNotFoundException;
import CollegeProject.Models.Address_Model;
import CollegeProject.Repositories.AddressRepository;
import CollegeProject.Repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Address_Model createNewAddress(Address address, int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException());
        address.setCustomer(customer);
        return modelMapper.map(addressRepository.save(address), Address_Model.class);
    }

    @Override
    public String deleteAddress(int customer_id, int address_id) {
        Customer customer = customerRepository.findById(customer_id).orElseThrow(()->new ResourceNotFoundException());
        List<Address> address = customer.getAddress();

        for (int index = 0; index < address.size(); index++) {
            if(address.get(index).getId().equals(address_id)){
                addressRepository.delete(address.get(index));
                return "Address successfully deleted !!";
            }
        }

        return "Address could not find !!";
    }

    @Override
    public Address_Model updateCustomerAddress(Address address, int customerId, int addressId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException());
        List<Address> addresses = customer.getAddress();

        for (int index = 0; index < addresses.size(); index++) {
            if(addresses.get(index).getId().equals(addressId)){
                Address currentAddress = addresses.get(index);
                currentAddress.setCity(address.getState());
                currentAddress.setCountry(address.getCountry());
                currentAddress.setStreet(address.getStreet());
                currentAddress.setState(address.getState());
                currentAddress.setZipcode(address.getZipcode());
                currentAddress.setCity(address.getCity());

                return modelMapper.map(addressRepository.save(currentAddress), Address_Model.class);
            }
        }
        return null;
    }

    @Override
    public Address_Model getACustomerAddress(int customerId, int addressId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException());
        List<Address> addresses = customer.getAddress();

        for (int index = 0; index < addresses.size(); index++) {
            if(addresses.get(index).getId().equals(addressId)){
                return modelMapper.map(addresses.get(index), Address_Model.class);
            }
        }
        return null;
    }

    @Override
    public List<Address_Model> getAllCustomerAddress(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException());
        List<Address> addresses = customer.getAddress();
        return addresses.stream().map(address -> modelMapper.map(address, Address_Model.class)).collect(Collectors.toList());
    }
}
