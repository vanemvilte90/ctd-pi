package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.RoleDto;
import grupo7.proyectoIntegrador.dto.UserDto;
import grupo7.proyectoIntegrador.entities.Role;
import grupo7.proyectoIntegrador.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    private ModelMapper modelMapper;

    /**
     * INstancia ProductMapper
     */
    private final ProductMapper prodMapper;

    public UserMapper(ModelMapper modelMapper, ProductMapper prodMapper) {
        this.modelMapper = modelMapper;
        this.prodMapper = prodMapper;
    }

    /**
     * Entity ->  mapToDto
     */
    public UserDto mapToDto(User userEntity) {

        log.info("*** userEntity {}", userEntity);

        RoleDto role = modelMapper.map(userEntity.getRole(), RoleDto.class);

        UserDto dto = modelMapper.map(userEntity, UserDto.class);
        dto.setRole(role);

        log.info("*** userDto {}", dto);

        return dto;
    }

    /**
     * mapToDto -> Entity
     */
    public User mapToEntity(UserDto userDto) {

        log.info("*** userDto Dto {}", userDto);

         // Role role = modelMapper.map(userDto.getRole(), Role.class);

        User entity = modelMapper.map(userDto, User.class);
       //  entity.setRole(role);

        log.info("*** user Entity {}", entity);

        return entity;
    }


    /**
     * List Entity -> mapListDto
     */
    public List<UserDto> mapToListDto(List<User> listUserEntity) {
        log.info("List<UserEntity>: {}", listUserEntity);

        List<UserDto> listUserDto = listUserEntity
                .stream()
                .map(UserEntity -> mapToDto(UserEntity))
                .collect(Collectors.toList());

        log.info("List<UserDto>: {}", listUserDto);
        return listUserDto;
    }

    /**
     * List Entity -> mapListDto
     */
    public List<User> mapToListEntity(List<UserDto> listUserDto) {
        log.info("List<UserDto>: {}", listUserDto);

        List<User> listUserEntity = listUserDto
                .stream()
                .map(UserDto -> mapToEntity(UserDto))
                .collect(Collectors.toList());

        log.info("List<UserEntity>: {}", listUserEntity);
        return listUserEntity;
    }
}
