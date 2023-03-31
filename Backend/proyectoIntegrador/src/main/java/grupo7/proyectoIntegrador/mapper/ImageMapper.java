package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.ImageDto;
import grupo7.proyectoIntegrador.entities.Image;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ImageMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Entity ->  mapToDto
     */
    public ImageDto mapToDto(Image ImagenEntity) {

        log.info("*** ImagenEntity {}", ImagenEntity);

        ImageDto dto = modelMapper.map(ImagenEntity, ImageDto.class);

        log.info("*** ImagenDto {}", dto);

        return dto;
    }

    /**
     * mapToDto -> Entity
     */
    public Image mapToEntity(ImageDto ImagenDto) {

        log.info("*** ImagenDto Dto {}", ImagenDto);

        Image entity = modelMapper.map(ImagenDto, Image.class);

        log.info("*** Imagen Entity {}", entity);

        return entity;
    }


    /**
     * List Entity -> mapListDto
     */
    public List<ImageDto> mapToListDto(List<Image> listImageEntity) {
        log.info("List<ImageEntity>: {}", listImageEntity);

        List<ImageDto> listImageDto = listImageEntity
                .stream()
                .map(ImageEntity -> mapToDto(ImageEntity))
                .collect(Collectors.toList());

        log.info("List<ImageDto>: {}", listImageDto);
        return listImageDto;
    }

    /**
     * List Entity -> mapListDto
     */
    public List<Image> mapToListEntity(List<ImageDto> listImageDto) {
        log.info("List<ImageDto>: {}", listImageDto);

        List<Image> listImageEntity = listImageDto
                .stream()
                .map(ImageDto -> mapToEntity(ImageDto))
                .collect(Collectors.toList());

        log.info("List<ImageEntity>: {}", listImageEntity);
        return listImageEntity;
    }
}
