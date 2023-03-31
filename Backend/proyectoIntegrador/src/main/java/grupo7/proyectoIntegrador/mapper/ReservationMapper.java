package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.ProductDto;
import grupo7.proyectoIntegrador.dto.reservation.ReservationRequestDto;
import grupo7.proyectoIntegrador.dto.reservation.ReservationResponseDto;
import grupo7.proyectoIntegrador.dto.UserDto;
import grupo7.proyectoIntegrador.entities.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ReservationMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    private ModelMapper modelMapper;

    /**
     * Instancia ProductMapper
     */
    private final ProductMapper productMapper;

    /**
     * Instancia User Mapper
     */
    private final UserMapper userMapper;

    public ReservationMapper(ModelMapper modelMapper, ProductMapper productMapper, UserMapper userMapper) {
        this.modelMapper = modelMapper;
        this.productMapper = productMapper;
        this.userMapper = userMapper;
    }

    /**
     * Entity ->  mapToDto
     */
    public ReservationResponseDto mapToDto(Reservation reservationEntity) {

        log.info("*** reservationEntity {}", reservationEntity);
        ProductDto prodDto = productMapper.mapToDto(reservationEntity.getProduct());
        UserDto userDto = userMapper.mapToDto(reservationEntity.getUser());

        ReservationResponseDto dto = modelMapper.map(reservationEntity, ReservationResponseDto.class);
        dto.setProductDto(prodDto);
        dto.setUserDto(userDto);

        log.info("*** reservationDto {}", dto);

        return dto;
    }

    /**
     * mapToDto -> Entity
     */
    public Reservation mapToEntity(ReservationRequestDto reservationDto) {

        log.info("*** reservationDto Dto {}", reservationDto);

        Reservation entity = modelMapper.map(reservationDto, Reservation.class);

        log.info("*** reservation Entity {}", entity);

        return entity;
    }


    /**
     * List Entity -> mapListDto
     */
    public List<ReservationResponseDto> mapToListDto(List<Reservation> listReservationEntity) {
        //log.info("List<ReservationEntity>: {}", listReservationEntity);

        List<ReservationResponseDto> listReservationDto = listReservationEntity
                .stream()
                .map(ReservationEntity -> mapToDto(ReservationEntity))
                .collect(Collectors.toList());

        //log.info("List<ReservationDto>: {}", listReservationDto);
        return listReservationDto;
    }

    /**
     * List Dto -> mapListEntity
     */
    public List<Reservation> mapToListEntity(List<ReservationRequestDto> listReservationDto) {
        //log.info("List<ReservationDto>: {}", listReservationDto);

        List<Reservation> listReservationEntity = listReservationDto
                .stream()
                .map(ReservationDto -> mapToEntity(ReservationDto))
                .collect(Collectors.toList());

        //log.info("List<ReservationEntity>: {}", listReservationEntity);
        return listReservationEntity;
    }
}
