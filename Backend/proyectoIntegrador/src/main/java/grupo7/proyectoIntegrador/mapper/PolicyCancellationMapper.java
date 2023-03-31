package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.PolicyCancellationDto;
import grupo7.proyectoIntegrador.entities.PolicyCancellation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PolicyCancellationMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    @Autowired
    private ModelMapper modelMapper;


    /**
     * Entity ->  mapToDto
     */
    public PolicyCancellationDto mapToDto(PolicyCancellation PolicyCancellationEntity) {

        log.info("*** PolicyCancellationEntity {}", PolicyCancellationEntity);

        PolicyCancellationDto dto = modelMapper.map(PolicyCancellationEntity, PolicyCancellationDto.class);

        log.info("*** PolicyCancellationnDto {}", dto);

        return dto;
    }

    /**
     * mapToDto -> Entity
     */
    public PolicyCancellation mapToEntity(PolicyCancellationDto PolicyCancellationnDto) {

        log.info("*** PolicyCancellationnDto Dto {}", PolicyCancellationnDto);

        PolicyCancellation entity = modelMapper.map(PolicyCancellationnDto, PolicyCancellation.class);

        log.info("*** PolicyCancellationn Entity {}", entity);

        return entity;
    }


    /**
     * List Entity -> mapListDto
     */
    public List<PolicyCancellationDto> mapToListDto(List<PolicyCancellation> listPolicyCancellationEntity) {
        log.info("List<PolicyCancellationEntity>: {}", listPolicyCancellationEntity);

        List<PolicyCancellationDto> listPolicyCancellationDto = listPolicyCancellationEntity
                .stream()
                .map(PolicyCancellationEntity -> mapToDto(PolicyCancellationEntity))
                .collect(Collectors.toList());

        log.info("List<PolicyCancellationDto>: {}", listPolicyCancellationDto);
        return listPolicyCancellationDto;
    }

    /**
     * List Entity -> mapListDto
     */
    public List<PolicyCancellation> mapToListEntity(List<PolicyCancellationDto> listPolicyCancellationDto) {
        log.info("List<PolicyCancellationDto>: {}", listPolicyCancellationDto);

        List<PolicyCancellation> listPolicyCancellationEntity = listPolicyCancellationDto
                .stream()
                .map(PolicyCancellationDto -> mapToEntity(PolicyCancellationDto))
                .collect(Collectors.toList());

        log.info("List<PolicyCancellationEntity>: {}", listPolicyCancellationEntity);
        return listPolicyCancellationEntity;
    }
}
