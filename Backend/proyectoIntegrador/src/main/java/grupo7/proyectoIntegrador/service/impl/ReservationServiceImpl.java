package grupo7.proyectoIntegrador.service.impl;

import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.service.IReservationService;
import grupo7.proyectoIntegrador.dto.reservation.ReservationRequestDto;
import grupo7.proyectoIntegrador.dto.reservation.ReservationResponseDto;
import grupo7.proyectoIntegrador.entities.Product;
import grupo7.proyectoIntegrador.entities.Reservation;
import grupo7.proyectoIntegrador.entities.User;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.mapper.ReservationMapper;
import grupo7.proyectoIntegrador.repository.IProductRepository;
import grupo7.proyectoIntegrador.repository.IReservationRepository;
import grupo7.proyectoIntegrador.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ReservationServiceImpl implements IReservationService {

    /**
     * Instancia Product Repository
     */
    private final IProductRepository productRepository;

    /**
     * Instancia User Repository.
     */
    private final IUserRepository userRepository;

    /**
     * Instancia Reservation Repository
     */
    private final IReservationRepository reservationRespository;

    /**
     * Instancia Reservation Mapper
     *
     * @param reservationRespository
     */
    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(IProductRepository productRepository, IUserRepository userRepository, IReservationRepository reservationRespository, ReservationMapper reservationMapper) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.reservationRespository = reservationRespository;
        this.reservationMapper = reservationMapper;
    }

    /**
     * Obtener la todas las reservas.
     *
     * @param reservation
     */
    @Transactional
    @Override
    public ReservationResponseDto createReservation(ReservationRequestDto reservation) throws ElementNotFoundException, ExistingException {

        log.info("*** reservationResponse Request {}", reservation);
        //Realizo las validaciones del producto, usuario.
        Product prod = productRepository.findById(reservation.getProductId())
                .orElseThrow(() -> new ElementNotFoundException(String.format("El Prducto el cual quiere reservar no esta disponible")));

        User user = userRepository.findById(reservation.getUserId())
                .orElseThrow(() -> new ElementNotFoundException(String.format("El Usuario no se encuentra registrado")));

        Reservation reservation1 = reservationMapper.mapToEntity(reservation);

        //Obtenemos la lista de resrvaciones registradas en la BD.
        List<Reservation> reservationEntitys = reservationRespository.findAll();

        //Comparo que las reservas no sean del mismo producto en las mismas fechas.
        for (Reservation reserva : reservationEntitys) {
            if (reserva.equals(reservation1)) {
                throw new ExistingException(String.format("Reserva para el producto con id: %s en estas fechas no esta disponible",
                        reservation.getProductId()));
            }
        }

        reservation1.setProduct(prod);
        reservation1.setUser(user);

        Reservation reservationResponse = reservationRespository.save(reservation1);
        log.info("*** reservationResponse Entity {}", reservationResponse);

        return reservationMapper.mapToDto(reservationResponse);
    }

    /**
     * Obtener la lista de reservas relacionadas a un producto id.
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<ReservationResponseDto> findReservationByProductId(Long id) throws ElementNotFoundException {

        if (!productRepository.findById(id).isPresent()) {
            throw new ElementNotFoundException(String.format("El product con id: %s Not Found", id));
        }

        List<Reservation> listReservation = reservationRespository.findReservationsByProductId(id).orElseThrow(
                () -> new ElementNotFoundException(String.format("El producto con id: %s, no tiene reservas asociadas", id))
        );

        List<ReservationResponseDto> listReservationDto = listReservation.stream()
                .map(reserv -> reservationMapper.mapToDto(reserv))
                .collect(Collectors.toList());

        return listReservationDto;
    }

    /**
     * Obtener la lista de reservas relacionadas a un usuario id
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<ReservationResponseDto> findReservationsByUserId(Long id) throws ElementNotFoundException {

        if (!userRepository.findById(id).isPresent()) {
            throw new ElementNotFoundException(String.format("El User con id: %s Not Found", id));
        }

        List<Reservation> listReservation = reservationRespository.findReservationsByUserId(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("El User con id: %s, no tiene reservas asociadas", id)));

        List<ReservationResponseDto> listReservationDto = listReservation.stream()
                .map(reserv -> reservationMapper.mapToDto(reserv))
                .collect(Collectors.toList());

        return listReservationDto;

    }

    /**
     * Obtener la todas las reservas.
     *
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<ReservationResponseDto> getAll() {
        return reservationMapper.mapToListDto(reservationRespository.findAll());
    }

    /**
     * Obtener reservation por id
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public ReservationResponseDto readReservationById(Long id) {
        return reservationMapper.mapToDto(reservationRespository.getById(id));
    }

    /**
     * Eliminar Reservation por id.
     *
     * @param id
     */
    @Transactional
    @Override
    public void deleteReservationById(Long id) {
        reservationRespository.deleteById(id);
    }
}
