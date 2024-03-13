package CollegeProject.Repositories;

import CollegeProject.Entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface WishlistRepository extends JpaRepository<WishList, Integer> {
    public List<WishList> findByCustomerId(Integer customer_id);
}
