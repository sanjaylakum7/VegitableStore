package CollegeProject.Service;

import CollegeProject.Entities.Product;
import CollegeProject.Entities.Testimonials;
import CollegeProject.Exception.ResourceNotFoundException;
import CollegeProject.Models.Testimonials_Model;
import CollegeProject.Repositories.ProductRepository;
import CollegeProject.Repositories.TestimonialsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestimonialsServiceImpl implements TestimonialsService{

    @Autowired
    private TestimonialsRepository testimonialsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Testimonials_Model createTestimonials(Testimonials testimonials, Integer product_id) {
        Product product = productRepository.findById(product_id).orElseThrow(()-> new ResourceNotFoundException());
        testimonials.setProduct(product);

        return modelMapper.map(testimonialsRepository.save(testimonials), Testimonials_Model.class);
    }
}
