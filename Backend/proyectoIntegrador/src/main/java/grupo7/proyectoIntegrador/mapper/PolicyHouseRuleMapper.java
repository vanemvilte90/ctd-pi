package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.PolicyHouseRuleDto;
import grupo7.proyectoIntegrador.entities.PolicyHouseRule;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PolicyHouseRuleMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    @Autowired
    private ModelMapper modelMapper;


    /**
     * Entity ->  mapToDto
     */
    public PolicyHouseRuleDto mapToDto(PolicyHouseRule PolicyHouseRuleEntity) {

        log.info("*** PolicyHouseRuleEntity {}", PolicyHouseRuleEntity);

        PolicyHouseRuleDto dto = modelMapper.map(PolicyHouseRuleEntity, PolicyHouseRuleDto.class);

        log.info("*** PolicyHouseRulenDto {}", dto);

        return dto;
    }

    /**
     * mapToDto -> Entity
     */
    public PolicyHouseRule mapToEntity(PolicyHouseRuleDto PolicyHouseRulenDto) {

        log.info("*** PolicyHouseRulenDto Dto {}", PolicyHouseRulenDto);

        PolicyHouseRule entity = modelMapper.map(PolicyHouseRulenDto, PolicyHouseRule.class);

        log.info("*** PolicyHouseRulen Entity {}", entity);

        return entity;
    }


    /**
     * List Entity -> mapListDto
     */
    public List<PolicyHouseRuleDto> mapToListDto(List<PolicyHouseRule> listPolicyHouseRuleEntity) {
        log.info("List<PolicyHouseRuleEntity>: {}", listPolicyHouseRuleEntity);

        List<PolicyHouseRuleDto> listPolicyHouseRuleDto = listPolicyHouseRuleEntity
                .stream()
                .map(PolicyHouseRuleEntity -> mapToDto(PolicyHouseRuleEntity))
                .collect(Collectors.toList());

        log.info("List<PolicyHouseRuleDto>: {}", listPolicyHouseRuleDto);
        return listPolicyHouseRuleDto;
    }

    /**
     * List Entity -> mapListDto
     */
    public List<PolicyHouseRule> mapToListEntity(List<PolicyHouseRuleDto> listPolicyHouseRuleDto) {
        log.info("List<PolicyHouseRuleDto>: {}", listPolicyHouseRuleDto);

        List<PolicyHouseRule> listPolicyHouseRuleEntity = listPolicyHouseRuleDto
                .stream()
                .map(PolicyHouseRuleDto -> mapToEntity(PolicyHouseRuleDto))
                .collect(Collectors.toList());

        log.info("List<PolicyHouseRuleEntity>: {}", listPolicyHouseRuleEntity);
        return listPolicyHouseRuleEntity;
    }
}
