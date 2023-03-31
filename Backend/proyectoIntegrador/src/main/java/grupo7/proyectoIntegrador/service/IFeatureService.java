package grupo7.proyectoIntegrador.service;

import grupo7.proyectoIntegrador.dto.FeatureDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;

import java.util.Collection;

public interface IFeatureService {

    /**
     * Crear Feature
     *
     * @param dto
     * @return
     */
    FeatureDto createFeature(FeatureDto dto) throws ExistingException, ElementNotFoundException;

    /**
     * Listar todas los Features.
     */
    Collection<FeatureDto> getAllProduct();


    /**
     * Buscar Feature por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    FeatureDto findById(Long id) throws ElementNotFoundException;


    /**
     * Buscar Feature por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    FeatureDto findByName(String name) throws ElementNotFoundException;


    /**
     * Actualizar Feature.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    FeatureDto update(FeatureDto dto) throws ElementNotFoundException;


    /**
     * Eliminar Feature.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    void delete(Long id) throws ElementNotFoundException;
}
