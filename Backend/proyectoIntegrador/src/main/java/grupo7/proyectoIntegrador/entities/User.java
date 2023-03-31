package grupo7.proyectoIntegrador.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    /**
     * Id hace refrencia a la Pk de la tabla Roles
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name hace referencia al nombre que tendra el usuario.
     */
    @Column(nullable = false, length = 40)
    private String name;

    /**
     * last name hace referencia al apellido del usuario.
     */
    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    /**
     * mail hace referencia al mail correspondiente al usuario.
     */
    @Column(name = "mail", unique = true)
    private String mail;

    /**
     * password hace referencia a la contraseña del usuario.
     */
    private String password;

    /**
     * Relacion User - Role
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rol_id", nullable = false)
    @JsonIgnore
    private Role role;


    /**
     * Equals() and hashCode()
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(mail, user.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, mail);
    }
}
