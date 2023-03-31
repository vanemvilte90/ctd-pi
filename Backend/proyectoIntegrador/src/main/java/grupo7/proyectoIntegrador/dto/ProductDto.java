package grupo7.proyectoIntegrador.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import grupo7.proyectoIntegrador.dto.reservation.ReservationRequestDto;
import grupo7.proyectoIntegrador.dto.reservation.ReservationResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    /**
     * id hace referencia a la primary key que representa cada Producto.
     * id autoincremental por la BD.
     */
    private Long id;

    /**
     * Name hace referencia al nombre del producto
     */
    @NotBlank(message = "Atributo Name no puede ser Null o Vacio")
    @Size(max = 50, message = "Longitud maxima del nombre 50 caracteres")
    private String name;

    /**
     * descriptionTitle hace referencia al nombre del producto
     */
    @NotBlank(message = "Atributo descriptionTitle no puede ser Null o Vacio")
    @Size(max = 80, message = "Longitud maxima del descriptionTitle 80 caracteres")
    private String descriptionTitle;

    /**
     * description hace referencia a la descripcion del producto.
     */
    @NotBlank(message = "Atributo descripcion no puede ser Null o Vacio")
    @Size(max = 1000, message = "Longitud maxima del nombre 1000 caracteres")
    private String description;

    /**
     * Hace referencia a la ubicacion en el mapa del producto
     */
    @NotBlank(message = "Atributo no puede ser Null o Vacio")
    @Size(max = 30, message = "Longitud maxima 30 caracteres")
    private String latitude;

    /**
     * Hace referencia a la ubicacion en el mapa del producto
     */
    @NotBlank(message = "Atributo no puede ser Null o Vacio")
    @Size(max = 30, message = "Longitud maxima 30 caracteres")
    private String longitude;

    /**
     * es una referencia a la ubicacion del producto.
     */
    @NotBlank(message = "Atributo no puede ser Null o Vacio")
    @Size(max = 60, message = "Longitud maxima 60 caracteres")
    private String reference;

    /**
     * hace referencia a la direccion concreta del producto.
     */
    @NotBlank(message = "Atributo no puede ser Null o Vacio")
    @Size(max = 30, message = "Longitud maxima 30 caracteres")
    private String address;

    /**
     * rating hace referencia a la valoracion del producto dada por el usuario
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int rating;

    /**
     * Relacion Product - Category
     */
    @NotNull(message = "Atributo No puede ser Null")
    @Valid
    private CategoryDto categoryDto;

    /**
     * Relacion Product - City
     */
    @NotNull(message = "Atributo No puede ser Null")
    @Valid
    private CityDto cityDto;

    /**
     * Relacion Product - Image
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ImageDto> imagesDto;

    /**
     * Relacion Product - Image
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FeatureDto> featureDto;

    /**
     * Relacion Product - Reservation
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ReservationRequestDto> reservations;

    /**
     * Lista de fechas reservadas
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private List<LocalDate> listDates;

    /**
     * Relacion Product - Policys
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PolicyHouseRuleDto> policyHouseRulesDto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PolicyCancellationDto> policyCancellationDto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PolicyHealthAndSecurityDto> policyHealthSecurityDto;


}
