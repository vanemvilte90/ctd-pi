package grupo7.proyectoIntegrador.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    /**
     * id hace referencia a la primary key que representa cada categoria.
     * id autoincremental por la BD.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * titulo hace referencia al titulo de la categoria.
     */
    @Column(nullable = false, length = 60)
    private String title;

    /**
     * descripcion hace referencia a la descripcion de la categoria.
     */
    @Column(nullable = false, length = 200)
    private String description;

    /**
     * imagenURL hace referencia a la Url que representa la imagen de la categoria.
     */
    @Column(name = "url_img", nullable = false)
    private String imageUrl;

    /**
     * equals() and hashCode()
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(title, category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
