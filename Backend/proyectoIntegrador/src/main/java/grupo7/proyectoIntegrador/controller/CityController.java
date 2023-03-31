package grupo7.proyectoIntegrador.controller;

import grupo7.proyectoIntegrador.dto.CityDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.service.ICityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {


    /**
     * Instancia de ciudad Service
     */
    private final ICityService cityService;

    /**
     * Inyeccion de dependencias por Constructor.
     *
     * @param cityService
     */
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }


    /**
     * Crear ciudad.
     *
     * @param ciudad
     * @return
     * @throws ExistingException
     */
    @PostMapping
    public ResponseEntity<CityDto> createCity(@Valid @RequestBody CityDto ciudad) throws ExistingException {
        return new ResponseEntity<>(cityService.createCity(ciudad), HttpStatus.CREATED);
    }

    /**
     * Listar todas las ciudads.
     *
     * @return List<CityDto>
     */
    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCity() {
        return ResponseEntity.ok(cityService.getAllCity());
    }

    /**
     * Buscar ciudad por Id.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<CityDto> findCityById(@PathVariable Long id) throws ElementNotFoundException {
        return ResponseEntity.ok(cityService.findById(id));
    }

    /**
     * Buscar ciudad por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<CityDto> findCityByTitle(@PathVariable String name) throws ElementNotFoundException {
        return ResponseEntity.ok(cityService.findByName(name));
    }

    /**
     * Actualizar ciudad.
     *
     * @param ciudad
     * @return
     * @throws ElementNotFoundException
     */
    @PostMapping("/actualizar")
    public ResponseEntity<CityDto> updateCity(@Valid @RequestBody CityDto ciudad) throws ElementNotFoundException {
        return ResponseEntity.ok(cityService.update(ciudad));
    }

    /**
     * Eliminar ciudad.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id) throws ElementNotFoundException {
        cityService.delete(id);
        return ResponseEntity.ok("Se elimino la city con id: " + id);
    }
}
