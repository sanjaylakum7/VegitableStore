package CollegeProject.Models;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer_Model {
    private Integer id;
    private String firstname;
    private String lastname;
    private String emailId;
    private boolean isLogin;
    private String phoneNo;
    private String password;
    private List<Address_Model> address;
}
