package lvn.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

    private String brand;

    private String madeIn;

    private float price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore()
    private Set<Item> items;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "category_id")
    @JsonIgnoreProperties(value = "product")
    private Category category;
}
