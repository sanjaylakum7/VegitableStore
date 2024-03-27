package CollegeProject.Models;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer_Model {
    private Integer id;
    private String firstname;
    private String emailId;
    private String phoneNo;
    private String gender;
    private String password;
    private List<Address_Model> address;
}
