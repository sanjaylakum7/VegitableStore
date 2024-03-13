package CollegeProject.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Testimonials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int rating;
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
