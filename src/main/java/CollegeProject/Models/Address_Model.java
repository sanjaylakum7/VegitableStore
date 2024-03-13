package CollegeProject.Models;

import CollegeProject.Entities.Customer;
import lombok.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address_Model {
    private Integer id;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
