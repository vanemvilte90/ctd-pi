package grupo7.proyectoIntegrador.service.impl;

import grupo7.proyectoIntegrador.dto.ImageDto;
import grupo7.proyectoIntegrador.entities.Image;
import grupo7.proyectoIntegrador.mapper.ImageMapper;
import grupo7.proyectoIntegrador.repository.IImageRepository;
import grupo7.proyectoIntegrador.service.IImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements IImageService {

    /**
     * Instancia Imagen Mapper.
     */
    private final ImageMapper imgMapper;

    /**
     * Instancia Imagen Repository.
     */
    private final IImageRepository imgRepository;

    public ImageServiceImpl(ImageMapper imgMapper, IImageRepository imgRepository) {
        this.imgMapper = imgMapper;
        this.imgRepository = imgRepository;
    }

    /**
     * getMainHousingByTitle
     *
     * @param title
     * @return
     */
    @Override
    public ImageDto getMainHousingByTitle(String title) {
        Image img = imgRepository.findMainHousingByTitle(title).orElse(null);
        return imgMapper.mapToDto(img);
    }


}
