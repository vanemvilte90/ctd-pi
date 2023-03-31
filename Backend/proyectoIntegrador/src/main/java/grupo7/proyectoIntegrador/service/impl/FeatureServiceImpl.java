package grupo7.proyectoIntegrador.service.impl;

import grupo7.proyectoIntegrador.service.IFeatureService;
import grupo7.proyectoIntegrador.dto.FeatureDto;
import grupo7.proyectoIntegrador.entities.Feature;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.mapper.FeatureMapper;
import grupo7.proyectoIntegrador.repository.IFeatureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class FeatureServiceImpl implements IFeatureService {


    /**
     * Instancia de Feature Repository.
     */
    private final IFeatureRepository featureRepository;

    /**
     * Instancia Feature Mapper
     */
    private final FeatureMapper featureMapper;

    /**
     * Inyeccion de dependencias por Constructor.
     *
     * @param featureRepository
     * @param featureMapper
     */
    public FeatureServiceImpl(IFeatureRepository featureRepository, FeatureMapper featureMapper) {
        this.featureRepository = featureRepository;
        this.featureMapper = featureMapper;
    }

    /**
     * Crear Feature
     *
     * @param dto
     * @return
     */
    @Transactional
    @Override
    public FeatureDto createFeature(FeatureDto dto) throws ExistingException {
        Feature featureStored = null;

        featureStored = featureRepository.findByName(dto.getName()).orElse(null);

        if (featureStored == null) {
            Feature featurEntity = featureMapper.mapToEntity(dto);
            featureStored = featureRepository.save(featurEntity);

            log.info("Respuesta service feature metodo save: {}", featureStored);
        }
        return featureMapper.mapToDto(featureStored);
    }

    /**
     * Listar todas los Features.
     */
    @Transactional(readOnly = true)
    @Override
    public Collection<FeatureDto> getAllProduct() {

        List<Feature> feature = featureRepository.findAll();

        return featureMapper.mapToListDto(feature);
    }

    /**
     * Buscar Feature por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public FeatureDto findById(Long id) throws ElementNotFoundException {

        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Caracteristica con id: %s Not Found", id)));

        return featureMapper.mapToDto(feature);
    }

    /**
     * Buscar Feature por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public FeatureDto findByName(String name) throws ElementNotFoundException {

        Feature feature = featureRepository.findByName(name)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Caracteristica con name: %s Not Found", name)));

        return featureMapper.mapToDto(feature);
    }

    /**
     * Actualizar Feature.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional
    @Override
    public FeatureDto update(FeatureDto dto) throws ElementNotFoundException {

        featureRepository.findById(dto.getId())
                .orElseThrow(() -> new ElementNotFoundException(String.format("Caracteristica con id: %s Not Found", dto.getId())));

        Feature entity = featureMapper.mapToEntity(dto);
        featureRepository.save(entity);

        return dto;
    }

    /**
     * Eliminar Feature.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    @Transactional
    @Override
    public void delete(Long id) throws ElementNotFoundException {

        featureRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(
                        String.format("Caracteristica con id: %s Not Found", id)));

        featureRepository.deleteById(id);
    }
}
