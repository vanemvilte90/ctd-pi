package grupo7.proyectoIntegrador.repository;

import grupo7.proyectoIntegrador.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    /**
     * Obtener las reservas asociadas a un producto.
     *
     * @param id
     * @return
     */
    @Query("SELECT r FROM Reservation r WHERE r.product.id = :id")
    Optional<List<Reservation>> findReservationsByProductId(@Param("id") Long id);

    /**
     * Obtener reservas asociadas a un usuario.
     *
     * @param id
     * @return
     */
    @Query("SELECT r FROM Reservation r WHERE r.user.id = :id")
    Optional<List<Reservation>> findReservationsByUserId(@Param("id") Long id);
}
