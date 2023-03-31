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
@Table(name = "images")
public class Image {

    /**
     * id hace referencia a la PK que representa cada imagen en la tabla.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * title hace referencia al titulo que tiene cada imagen
     */
    @Column(name = "title", length = 60)
    private String title;

    /**
     * urlImg hace referencia a la url que corresponde cada imagen
     */
    @Column(name = "url_img", unique = false)
    private String urlImg;

    /**
     * equals() & hashCode()
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) && Objects.equals(title, image.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
