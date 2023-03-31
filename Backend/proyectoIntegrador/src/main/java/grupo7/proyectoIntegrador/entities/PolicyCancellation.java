package grupo7.proyectoIntegrador.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "policies_cancellation")
public class PolicyCancellation {

    /**
     * Hace referencia a la PK de la tabla.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Hace referencia a la descripcion de las Politicas.
     */
    @Column(length = 10000)
    private String description;
}
