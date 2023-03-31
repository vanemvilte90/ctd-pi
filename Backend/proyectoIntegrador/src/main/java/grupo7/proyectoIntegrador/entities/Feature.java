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
@Table(name = "features")
public class Feature {

    /**
     * Hace referenica a la PK que represneta cada feture.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name hace referencia al nombre de la caracteristica.
     */
    @Column(nullable = false, length = 50)
    private String name;


    /**
     * Equals() and hashCode()
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(id, feature.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
