package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.FeatureDto;
import grupo7.proyectoIntegrador.entities.Feature;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class FeatureMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Entity ->  mapToDto
     */
    public FeatureDto mapToDto(Feature featureEntity) {

        log.info("*** featureEntity {}", featureEntity);

        FeatureDto dto = modelMapper.map(featureEntity, FeatureDto.class);

        log.info("*** featureDto {}", dto);

        return dto;
    }

    /**
     * Dto -> mapToEntity
     */
    public Feature mapToEntity(FeatureDto featureDto) {

        log.info("*** feature Dto {}", featureDto);

        Feature entity = modelMapper.map(featureDto, Feature.class);

        log.info("*** Feature Entity {}", entity);

        return entity;
    }


    /**
     * Set Entity -> mapListDto
     */
    public List<FeatureDto> mapToListDto(Collection<Feature> listFeatureEntity) {
        log.info("List<FeatureEntity>: {}", listFeatureEntity);

        List<FeatureDto> listFeatureDto = listFeatureEntity
                .stream()
                .map(FeatureEntity -> mapToDto(FeatureEntity))
                .collect(Collectors.toList());

        log.info("List<FeatureDto>: {}", listFeatureDto);
        return listFeatureDto;
    }

    /**
     * Set Dto -> mapListEntity
     */
    public List<Feature> mapToListEntity(Collection<FeatureDto> listFeatureDto) {
        log.info("Set<FeatureDto>: {}", listFeatureDto);

        List<Feature> listFeatureEntity = listFeatureDto
                .stream()
                .map(FeatureDto -> mapToEntity(FeatureDto))
                .collect(Collectors.toList());

        log.info("Set<FeatureEntity>: {}", listFeatureEntity);
        return listFeatureEntity;
    }
}
