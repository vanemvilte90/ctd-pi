package grupo7.proyectoIntegrador.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {

    /**
     * Id hace refrencia a la Pk de la tabla reservations
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Hace referencia a la hora de llegada al hotel
     */
    @Column(name = "time_arrival", nullable = false)
    private String timeOfArrival;

    /**
     * Hace referencia a la hora de la reservacion.
     */
    @Column(name = "start_time", nullable = false)
    private LocalDate startDate;

    /**
     * Hace referencia a la hora en que finaliza la reserva.
     */
    @Column(name = "final_time", nullable = false)
    private LocalDate finalDate;

    /**
     * Relacion Reservations - Product
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    /**
     * Relacion Product - Users
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    /**
     * equals() And hashCode()
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(startDate, that.startDate) && Objects.equals(finalDate, that.finalDate) && Objects.equals(product.getId(), that.product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, finalDate, product.getId());
    }
}
