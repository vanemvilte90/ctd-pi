package grupo7.proyectoIntegrador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDto {

    /**
     * Hace referenica a la PK que represneta cada feture.
     */
    private Long id;

    /**
     * Name hace referencia al nombre de la caracteristica.
     */
    @NotBlank(message = "Atributo Name no puede ser Null o Vacio")
    @Size(max = 50, message = "Longitud maxima del nombre 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String name;

}
