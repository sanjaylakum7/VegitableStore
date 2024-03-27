package CollegeProject.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String images;

    @Column(unique = true)
    private String name;

    private int price;
    private String description;
    private String store_name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "product")
    private List<Testimonials> testimonials;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;
}
