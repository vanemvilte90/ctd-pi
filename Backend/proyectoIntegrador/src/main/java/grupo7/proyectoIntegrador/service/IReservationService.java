package grupo7.proyectoIntegrador.service;


import grupo7.proyectoIntegrador.dto.reservation.ReservationRequestDto;
import grupo7.proyectoIntegrador.dto.reservation.ReservationResponseDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;

import java.util.List;

public interface IReservationService {

    /**
     * Crear una reserva.
     *
     * @param reservation
     */
    ReservationResponseDto createReservation(ReservationRequestDto reservation) throws ElementNotFoundException, ExistingException;

    /**
     * Obtener la lista de reservas relacionadas a un producto id.
     */
    List<ReservationResponseDto> findReservationByProductId(Long id) throws ElementNotFoundException;

    /**
     * Obtener la lista de reservas relacionadas a un usuario id
     */
    List<ReservationResponseDto> findReservationsByUserId(Long id) throws ElementNotFoundException;

    /**
     * Obtener la todas las reservas.
     */
    List<ReservationResponseDto> getAll();

    /**
     * Obtener reservation por id
     *
     * @param id
     * @return
     */
    ReservationResponseDto readReservationById(Long id); // Permite encontrar una reserva por su id.

    /**
     * Eliminar Reservation por id.
     *
     * @param id
     */
    void deleteReservationById(Long id); // Permite borrar una reserva por su id.


}
