package CollegeProject.Controllers;

import CollegeProject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

		@Autowired
		private CustomerService customerService;

		@GetMapping("login")
		public ResponseEntity<Boolean> login(@RequestParam("email") String email,
		                                     @RequestParam("password") String password){
				return new ResponseEntity<>(customerService.login(email, password), HttpStatus.OK);
		}
}
