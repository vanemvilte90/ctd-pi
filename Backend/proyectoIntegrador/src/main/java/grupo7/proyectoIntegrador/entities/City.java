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
@Table(name = "cities")
public class City {

    /**
     * Id hace refrencia a la Pk de la tabla Cities
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name hace referencia al nombre de cada city.
     */
    @Column(nullable = false, length = 40)
    private String name;

    /**
     * countryName Hace referencia al nombre del pais al que corresponde la city
     */
    @Column(name = "country_name", nullable = false, length = 40)
    private String countryName;


    /**
     * equals() & hashCode()
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
