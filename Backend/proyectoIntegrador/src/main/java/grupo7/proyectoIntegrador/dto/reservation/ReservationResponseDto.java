package grupo7.proyectoIntegrador.dto.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import grupo7.proyectoIntegrador.dto.ProductDto;
import grupo7.proyectoIntegrador.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDto {

    /**
     * Id hace refrencia a la Pk de la tabla reservations
     */

    private Long id;

    /**
     * Hace referencia a la hora de llegada al hotel
     */
    private String timeOfArrival;

    /**
     * Hace referencia a la hora de la reservacion.
     */
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

    /**
     * Hace referencia a la hora en que finaliza la reserva.
     */
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate finalDate;

    /**
     * Relacion Reservations - Product
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProductDto productDto;

    /**
     * Realcions Reservation - User
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDto userDto;

}
