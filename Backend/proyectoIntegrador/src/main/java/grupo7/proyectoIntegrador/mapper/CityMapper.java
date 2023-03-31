package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.CityDto;
import grupo7.proyectoIntegrador.entities.City;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CityMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Entity ->  mapToDto
     */
    public CityDto mapToDto(City ciudadEntity) {

        log.info("*** ciudadEntity {}", ciudadEntity);

        CityDto dto = modelMapper.map(ciudadEntity, CityDto.class);

        log.info("*** ciudadDto {}", dto);

        return dto;
    }

    /**
     * mapToDto -> Entity
     */
    public City mapToEntity(CityDto ciudadDto) {

        log.info("*** ciudadDto Dto {}", ciudadDto);

        City entity = modelMapper.map(ciudadDto, City.class);

        log.info("*** ciudad Entity {}", entity);

        return entity;
    }


    /**
     * List Entity -> mapListDto
     */
    public List<CityDto> mapToListDto(List<City> listCityEntity) {
        log.info("List<CityEntity>: {}", listCityEntity);

        List<CityDto> listCityDto = listCityEntity
                .stream()
                .map(CityEntity -> mapToDto(CityEntity))
                .collect(Collectors.toList());

        log.info("List<CityDto>: {}", listCityDto);
        return listCityDto;
    }

    /**
     * List Entity -> mapListDto
     */
    public List<City> mapToListEntity(List<CityDto> listCityDto) {
        log.info("List<CityDto>: {}", listCityDto);

        List<City> listCityEntity = listCityDto
                .stream()
                .map(CityDto -> mapToEntity(CityDto))
                .collect(Collectors.toList());

        log.info("List<CityEntity>: {}", listCityEntity);
        return listCityEntity;
    }
}
