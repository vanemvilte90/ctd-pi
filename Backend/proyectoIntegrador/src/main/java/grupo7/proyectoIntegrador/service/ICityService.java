package grupo7.proyectoIntegrador.service;

import grupo7.proyectoIntegrador.dto.CityDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;

import java.util.List;

public interface ICityService {

    /**
     * Crear Ciudad
     *
     * @param dto
     * @return
     */
    CityDto createCity(CityDto dto) throws ExistingException;

    /**
     * Listar todas las Ciudades.
     */
    List<CityDto> getAllCity();


    /**
     * Buscar Ciudad por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    CityDto findById(Long id) throws ElementNotFoundException;


    /**
     * Buscar Ciudad por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    CityDto findByName(String name) throws ElementNotFoundException;


    /**
     * Actualizar Ciudad.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    CityDto update(CityDto dto) throws ElementNotFoundException;


    /**
     * Eliminar Ciudad.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    void delete(Long id) throws ElementNotFoundException;

}
