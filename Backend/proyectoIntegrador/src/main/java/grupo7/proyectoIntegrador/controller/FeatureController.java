package grupo7.proyectoIntegrador.controller;

import grupo7.proyectoIntegrador.dto.FeatureDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.service.IFeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/features")
public class FeatureController {

    /**
     * Instancia de Feature Service.
     */
    private final IFeatureService featureService;

    /**
     * Inyeccion de dependencia por constructor.
     *
     * @param featureService
     */
    public FeatureController(IFeatureService featureService) {
        this.featureService = featureService;
    }

    /**
     * Crear Feature
     *
     * @param dto
     * @return
     */
    @PostMapping
    ResponseEntity<FeatureDto> createFeature(@Valid @RequestBody FeatureDto dto) throws ExistingException, ElementNotFoundException {
        FeatureDto featureDto = featureService.createFeature(dto);
        return new ResponseEntity<>(featureDto, HttpStatus.CREATED);
    }

    /**
     * Listar todas los Features.
     */
    @GetMapping
    ResponseEntity<Collection<FeatureDto>> getAllProduct() {
        return new ResponseEntity<>(featureService.getAllProduct(), HttpStatus.OK);
    }

    /**
     * Buscar Feature por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/id/{id}")
    ResponseEntity<FeatureDto> findById(@PathVariable Long id) throws ElementNotFoundException {
        return new ResponseEntity<>(featureService.findById(id), HttpStatus.OK);
    }


    /**
     * Buscar Feature por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/name/{name}")
    ResponseEntity<FeatureDto> findByName(@PathVariable String name) throws ElementNotFoundException {
        return ResponseEntity.ok(featureService.findByName(name));
    }


    /**
     * Actualizar Feature.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    @PostMapping("/actualizar")
    ResponseEntity<FeatureDto> update(@Valid @RequestBody FeatureDto dto) throws ElementNotFoundException {
        return ResponseEntity.ok(featureService.update(dto));
    }


    /**
     * Eliminar Feature.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) throws ElementNotFoundException {
        featureService.delete(id);
        return ResponseEntity.ok("Se elimino la feature con id: " + id);
    }
}
