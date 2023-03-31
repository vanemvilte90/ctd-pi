package grupo7.proyectoIntegrador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    /**
     * Id hace refrencia a la Pk de la tabla Roles
     */
    private Long id;

    /**
     * name hace referencia al nombre que tendra el role.
     */
    @NotBlank(message = "Atributo no puede ser Null o Vacio")
    @Size(max = 10, message = "Longitud maxima 10 caracteres")
    private String name;
}
