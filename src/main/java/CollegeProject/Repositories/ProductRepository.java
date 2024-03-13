package CollegeProject.Repositories;

import CollegeProject.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Optional<List<Product>> findByCategoryId(Integer categoryId);
}
