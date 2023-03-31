package grupo7.proyectoIntegrador.service;

import grupo7.proyectoIntegrador.dto.ImageDto;

public interface IImageService {

    /**
     * getMainHousingByTitle
     *
     * @param title
     * @return
     */
    public ImageDto getMainHousingByTitle(String title);
}
