package grupo7.proyectoIntegrador.controller;

import grupo7.proyectoIntegrador.dto.ImageDto;
import grupo7.proyectoIntegrador.service.impl.ImageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/img")
public class ImageController {

    /**
     * Instancia Imagen Service;
     */
    private final ImageServiceImpl imgService;

    /**
     * INyeccion de dependencias por constructor.
     *
     * @param imgService
     */
    public ImageController(ImageServiceImpl imgService) {
        this.imgService = imgService;
    }

    /**
     * getMainHousingByTitle
     *
     * @param title
     * @return
     */
    @GetMapping("/{title}")
    public ResponseEntity<ImageDto> geByTitle(@PathVariable String title) {
        return ResponseEntity.ok(imgService.getMainHousingByTitle(title));
    }


}
