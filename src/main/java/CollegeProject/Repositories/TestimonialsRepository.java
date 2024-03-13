package CollegeProject.Repositories;

import CollegeProject.Entities.Testimonials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialsRepository extends JpaRepository<Testimonials, Integer> {
}
