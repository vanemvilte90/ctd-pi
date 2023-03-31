package grupo7.proyectoIntegrador.dto;

import lombok.*;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyHouseRuleDto {

    /**
     * Hace referencia a la PK de la tabla.
     */
    private Long id;

    /**
     * Hace referencia a la descripcion de las Politicas.
     */
    @Size(max = 10000, message = "Longitud maxima de la descripcion 10000 caracteres")
    private String description;
}
