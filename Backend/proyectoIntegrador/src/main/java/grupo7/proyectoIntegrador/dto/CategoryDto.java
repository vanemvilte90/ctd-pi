package grupo7.proyectoIntegrador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {


    /**
     * id hace referencia a la primary key que representa cada categoria.
     * id autoincremental por la BD.
     */
    private Long id;

    /**
     * titulo hace referencia al titulo de la categoria.
     */
    @NotBlank(message = "Atributo titulo no puede ser Null o Vacio")
    @Size(max = 60, message = "Longitud maxima del nombre 60 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String title;

    /**
     * descripcion hace referencia a la descripcion de la categoria.
     */
    @NotBlank(message = "Atributo descripcion no puede ser Null o Vacio")
    @Size(max = 200, message = "Longitud maxima del nombre 100 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String description;

    /**
     * imagenURL hace referencia a la Url que representa la imagen de la categoria.
     */
    @NotBlank(message = "Atributo imagenUrl no puede ser Null o Vacio")
    private String imageUrl;


}
