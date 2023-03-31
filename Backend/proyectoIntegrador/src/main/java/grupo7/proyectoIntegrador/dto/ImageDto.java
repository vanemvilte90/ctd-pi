package grupo7.proyectoIntegrador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {

    /**
     * id hace referencia a la PK que representa cada imagen en la tabla.
     */
    private Long id;

    /**
     * title hace referencia al titulo que tiene cada imagen
     */
    @NotBlank(message = "Atributo title no puede ser Null o vacio")
    private String title;

    /**
     * urlImg hace referencia a la url que corresponde cada imagen
     */
    @NotBlank(message = "Atributo urlImg no puede ser Null o Vacio")
    private String urlImg;

}
