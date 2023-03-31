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
public class CityDto {

    /**
     * Id hace refrencia a la Pk de la tabla Cities
     */
    private Long id;

    /**
     * name hace referencia al nombre de cada city.
     */
    @NotBlank(message = "Atributo name no puede ser Null o Vacio")
    @Size(max = 40, message = "Longitud maxima del nombre 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String name;

    /**
     * countryName Hace referencia al nombre del pais al que corresponde la city
     */
    @NotBlank(message = "Atributo countryName no puede ser Null o Vacio")
    @Size(max = 40, message = "Longitud maxima del nombre 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String countryName;
}
