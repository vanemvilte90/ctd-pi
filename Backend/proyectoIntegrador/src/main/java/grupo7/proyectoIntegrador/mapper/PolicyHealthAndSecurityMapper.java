package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.PolicyHealthAndSecurityDto;
import grupo7.proyectoIntegrador.entities.PolicyHealthAndSecurity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PolicyHealthAndSecurityMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    @Autowired
    private ModelMapper modelMapper;


    /**
     * Entity ->  mapToDto
     */
    public PolicyHealthAndSecurityDto mapToDto(PolicyHealthAndSecurity PolicyHealthAndSecurityEntity) {

        log.info("*** PolicyHealthAndSecurityEntity {}", PolicyHealthAndSecurityEntity);

        PolicyHealthAndSecurityDto dto = modelMapper.map(PolicyHealthAndSecurityEntity, PolicyHealthAndSecurityDto.class);

        log.info("*** PolicyHealthAndSecuritynDto {}", dto);

        return dto;
    }

    /**
     * mapToDto -> Entity
     */
    public PolicyHealthAndSecurity mapToEntity(PolicyHealthAndSecurityDto PolicyHealthAndSecuritynDto) {

        log.info("*** PolicyHealthAndSecuritynDto Dto {}", PolicyHealthAndSecuritynDto);

        PolicyHealthAndSecurity entity = modelMapper.map(PolicyHealthAndSecuritynDto, PolicyHealthAndSecurity.class);

        log.info("*** PolicyHealthAndSecurityn Entity {}", entity);

        return entity;
    }


    /**
     * List Entity -> mapListDto
     */
    public List<PolicyHealthAndSecurityDto> mapToListDto(List<PolicyHealthAndSecurity> listPolicyHealthAndSecurityEntity) {
        log.info("List<PolicyHealthAndSecurityEntity>: {}", listPolicyHealthAndSecurityEntity);

        List<PolicyHealthAndSecurityDto> listPolicyHealthAndSecurityDto = listPolicyHealthAndSecurityEntity
                .stream()
                .map(PolicyHealthAndSecurityEntity -> mapToDto(PolicyHealthAndSecurityEntity))
                .collect(Collectors.toList());

        log.info("List<PolicyHealthAndSecurityDto>: {}", listPolicyHealthAndSecurityDto);
        return listPolicyHealthAndSecurityDto;
    }

    /**
     * List Entity -> mapListDto
     */
    public List<PolicyHealthAndSecurity> mapToListEntity(List<PolicyHealthAndSecurityDto> listPolicyHealthAndSecurityDto) {
        log.info("List<PolicyHealthAndSecurityDto>: {}", listPolicyHealthAndSecurityDto);

        List<PolicyHealthAndSecurity> listPolicyHealthAndSecurityEntity = listPolicyHealthAndSecurityDto
                .stream()
                .map(PolicyHealthAndSecurityDto -> mapToEntity(PolicyHealthAndSecurityDto))
                .collect(Collectors.toList());

        log.info("List<PolicyHealthAndSecurityEntity>: {}", listPolicyHealthAndSecurityEntity);
        return listPolicyHealthAndSecurityEntity;
    }
}
