package CollegeProject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CollegeProjectApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CollegeProjectApplication.class, args);
	}

//	i have t extend the class with that class -> extends SpringBootServletInitializer

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CollegeProjectApplication.class);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
