package grupo7.proyectoIntegrador.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    /**
     * id hace referencia a la primary key que representa cada Producto.
     * id autoincremental por la BD.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name hace referencia al nombre del producto
     */
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /**
     * descriptionTitle hace referencia al nombre del producto
     */
    @Column(name = "description_title", nullable = false, length = 80)
    private String descriptionTitle;

    /**
     * description hace referencia a la descripcion del producto.
     */
    @Column(nullable = false, length = 1000)
    private String description;

    /**
     * Hace referencia a la ubicacion en el mapa del producto
     */
    @Column(nullable = false, length = 30)
    private String latitude;

    /**
     * Hace referencia a la ubicacion en el mapa del producto
     */
    @Column(nullable = false, length = 30)
    private String longitude;

    /**
     * es una referencia a la ubicacion del producto.
     */
    @Column(nullable = false, length = 60)
    private String reference;

    /**
     * hace referencia a la direccion concreta del producto.
     */
    @Column(nullable = false, length = 30)
    private String address;

    /**
     * Hace referencia a la puntuacion del producto dada por los usuarios.
     */
    private int rating;

    /**
     * Relacion Products - Category
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private Category category;

    /**
     * Relacion Products - City
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "city_id", nullable = false)
    @JsonIgnore
    private City city;

    /**
     * Relacion Products - Image
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<Image> images;

    /**
     * Relacion Product - features
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_features",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private List<Feature> productFeatures;

    /**
     * Relacion Product - Reservation
     */
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Reservation> reservations;

    /**
     * Relacion Product - Policys
     */
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_policies_house_rules",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "policies_house_rules_id")
    )
    private List<PolicyHouseRule> policyHouseRules;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_policies_cancellation",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "policies_cancellation_id")
    )
    private List<PolicyCancellation> policyCancellation;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_policies_health_security",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "policies_health_security_id")
    )
    private List<PolicyHealthAndSecurity> policyHealthAndSecurity;


    /**
     * Equals and hashCode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
