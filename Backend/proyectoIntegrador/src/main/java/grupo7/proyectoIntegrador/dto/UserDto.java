package grupo7.proyectoIntegrador.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    /**
     * Id hace refrencia a la Pk de la tabla Roles
     */
    private Long id;

    /**
     * name hace referencia al nombre que tendra el usuario.
     */
    @NotBlank(message = "Atributo no puede ser Null o Vacio")
    @Size(max = 40, message = "Longitud maxima 40 caracteres")
    private String name;

    /**
     * last name hace referencia al apellido del usuario.
     */
    @NotBlank(message = "Atributo no puede ser Null o Vacio")
    @Size(max = 40, message = "Longitud maxima 40 caracteres")
    private String lastName;

    /**
     * mail hace referencia al mail correspondiente al usuario.
     */
    @Column(unique = true, columnDefinition = "Campo debe ser unico")
    @NotBlank(message = "Atributo no puede ser Null o Vacio")
    @Size(max = 80, message = "Longitud maxima 80 caracteres")
    private String mail;

    /**
     * password hace referencia a la contraseña del usuario.
     */
    @NotBlank(message = "Atributo no puede ser Null o Vacio")
    @Size(max = 20, message = "Longitud maxima 20 caracteres")
    private String password;

    /**
     * Relacion User - Role
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RoleDto role;

}

