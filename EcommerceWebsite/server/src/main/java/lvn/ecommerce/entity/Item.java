package lvn.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false, referencedColumnName = "cart_id")
    @JsonBackReference(value = "item-cart")
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "product_id")
    @JsonIgnoreProperties(value = "product")
    private Product product;

    private int quantity;
}
