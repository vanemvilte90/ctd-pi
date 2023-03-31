package grupo7.proyectoIntegrador.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    /**
     * Id hace refrencia a la Pk de la tabla Roles
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name hace referencia al nombre que tendra el role.
     */
    @Column(nullable = false, length = 10)
    private String name;


}
