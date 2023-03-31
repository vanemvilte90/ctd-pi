package grupo7.proyectoIntegrador.controller;

import grupo7.proyectoIntegrador.dto.reservation.ReservationRequestDto;
import grupo7.proyectoIntegrador.dto.reservation.ReservationResponseDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.service.IReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    /**
     * Instancia Reservation Service
     */
    private final IReservationService reservationService;

    /**
     * INyeccion de dependencias por constructor.
     *
     * @param reservationService
     */
    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }


    /**
     * Crear reservation.
     *
     * @param reservation
     * @return
     * @throws ExistingException
     */
    @PostMapping
    public ResponseEntity<ReservationResponseDto> createReservation(@Valid @RequestBody ReservationRequestDto reservation) throws ElementNotFoundException, ExistingException {

        return new ResponseEntity<>(reservationService.createReservation(reservation), HttpStatus.CREATED);
    }

    /**
     * Listar todas las reservations.
     *
     * @return List<ReservationDto>
     */
    @GetMapping
    public ResponseEntity<List<ReservationResponseDto>> getAllReservation() {
        return ResponseEntity.ok(reservationService.getAll());
    }

    /**
     * Buscar reservation por Product Id.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<List<ReservationResponseDto>> findReservationByProductId(@PathVariable Long id) throws ElementNotFoundException {
        return ResponseEntity.ok(reservationService.findReservationByProductId(id));
    }

    /**
     * Buscar reservation por User Id.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<List<ReservationResponseDto>> findReservationByUserId(@PathVariable Long id) throws ElementNotFoundException {
        return ResponseEntity.ok(reservationService.findReservationsByUserId(id));
    }

    /**
     * Buscar reservation por Id.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDto> findReservationById(@PathVariable Long id) throws ElementNotFoundException {
        return ResponseEntity.ok(reservationService.readReservationById(id));
    }

    /**
     * Eliminar reservation.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) throws ElementNotFoundException {
        reservationService.deleteReservationById(id);
        return ResponseEntity.ok("Se elimino la Reservation con id: " + id);
    }
}
