package CollegeProject.Controllers;

import CollegeProject.Entities.Testimonials;
import CollegeProject.Models.Testimonials_Model;
import CollegeProject.Service.TestimonialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apis/")
public class TestimonialsController {

    @Autowired
    private TestimonialsService testimonialsService;

    @PostMapping("public/product/{product_id}/testimonials")
    public ResponseEntity<Testimonials_Model> createTestimonials(@RequestBody Testimonials testimonials, @PathVariable("product_id") Integer product_id){
        return new ResponseEntity<>(testimonialsService.createTestimonials(testimonials, product_id), HttpStatus.CREATED);
    }
}
