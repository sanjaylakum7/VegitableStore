package CollegeProject.Service;

import CollegeProject.Entities.Testimonials;
import CollegeProject.Models.Testimonials_Model;

public interface TestimonialsService {
    public Testimonials_Model createTestimonials(Testimonials testimonials, Integer product_id);
}
