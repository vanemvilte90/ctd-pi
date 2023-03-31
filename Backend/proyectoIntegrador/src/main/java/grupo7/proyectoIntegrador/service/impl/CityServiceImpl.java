package grupo7.proyectoIntegrador.service.impl;

import grupo7.proyectoIntegrador.service.ICityService;
import grupo7.proyectoIntegrador.dto.CityDto;
import grupo7.proyectoIntegrador.entities.City;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.mapper.CityMapper;
import grupo7.proyectoIntegrador.repository.ICityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    /**
     * Instancia de City Repository.
     */
    private final ICityRepository cityRepository;

    /**
     * Instancia de CityMapper.
     */
    private final CityMapper cityMapper;

    /**
     * Inyeccion de dependencias por Constructor.
     *
     * @param cityRepository
     * @param cityMapper
     */
    public CityServiceImpl(ICityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    /**
     * Crear Ciudad
     *
     * @param dto
     * @return
     * @throws ExistingException
     */
    @Transactional
    @Override
    public CityDto createCity(CityDto dto) throws ExistingException {

        if (cityRepository.findByName(dto.getName()).isPresent()) {
            throw new ExistingException(String.format("City name: %s ya existe en BD", dto.getName()));
        }

        City cityEntity = cityMapper.mapToEntity(dto);
        City Entity = cityRepository.save(cityEntity);

        return cityMapper.mapToDto(Entity);
    }

    /**
     * Listar todas las Ciudades.
     */
    @Transactional(readOnly = true)
    @Override
    public List<CityDto> getAllCity() {

        List<City> cities = cityRepository.findAll();

        return cityMapper.mapToListDto(cities);
    }

    /**
     * Buscar Ciudad por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public CityDto findById(Long id) throws ElementNotFoundException {

        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException((String.format("City con id: %s Not Found", id))));

        return cityMapper.mapToDto(city);
    }

    /**
     * Buscar Ciudad por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    @Override
    public CityDto findByName(String name) throws ElementNotFoundException {

        City city = cityRepository.findByName(name)
                .orElseThrow(() -> new ElementNotFoundException((String.format("City con name: %s Not Found", name))));

        return cityMapper.mapToDto(city);
    }

    /**
     * Actualizar Ciudad.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    @Override
    public CityDto update(CityDto dto) throws ElementNotFoundException {

        cityRepository.findById(dto.getId())
                .orElseThrow(() -> new ElementNotFoundException((String.format("City con id: %s Not Found", dto.getId()))));

        City cEntity = cityMapper.mapToEntity(dto);

        cityRepository.save(cEntity);

        return dto;
    }

    /**
     * Eliminar Ciudad.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    @Override
    public void delete(Long id) throws ElementNotFoundException {

        cityRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException
                        (String.format("City con id: %s Not Found", id)));

        cityRepository.deleteById(id);
    }
}
