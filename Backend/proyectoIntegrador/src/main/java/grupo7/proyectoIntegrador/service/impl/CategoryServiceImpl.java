package grupo7.proyectoIntegrador.service.impl;

import grupo7.proyectoIntegrador.service.ICategoryService;
import grupo7.proyectoIntegrador.dto.CategoryDto;
import grupo7.proyectoIntegrador.entities.Category;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.mapper.CategoryMapper;
import grupo7.proyectoIntegrador.repository.ICategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    /**
     * Instancia de Categoria Repository
     */
    private final ICategoryRepository categoryRepository;

    /**
     * Instancia Categoria Mapper
     */
    private final CategoryMapper categoryMapper;

    /**
     * Inyeccion de dependencias por Constructor.
     *
     * @param categoryRepository
     * @param categoryMapper
     */
    public CategoryServiceImpl(ICategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    /**
     * Crear Categoria
     *
     * @param dto
     * @return
     */
    @Transactional
    @Override
    public CategoryDto createCategory(CategoryDto dto) throws ExistingException {

        //Category entity = categoryRepository.findByTitle(dto.getTitle()).orElse(null);
        if (categoryRepository.findByTitle(dto.getTitle()).isPresent()) {
            throw new ExistingException(String.format("Categoria titulo: %s ya existe en BD", dto.getTitle()));
        }

        Category categoryEntity = categoryMapper.mapToEntity(dto);
        Category entity = categoryRepository.save(categoryEntity);

        return categoryMapper.mapToDto(entity);

    }

    /**
     * Listar todas las categorias.
     */
    @Transactional(readOnly = true)
    @Override
    public List<CategoryDto> getAllCategory() {

        List<Category> categorias = categoryRepository.findAll();

        return categoryMapper.mapToListDto(categorias);
    }

    /**
     * Buscar categoria por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public CategoryDto findById(Long id) throws ElementNotFoundException {

        Category entity = categoryRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Categoria con id: %s Not Found", id)));

        return categoryMapper.mapToDto(entity);
    }


    /**
     * Buscar categoria por Titulo.
     *
     * @param title
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public CategoryDto findByTitle(String title) throws ElementNotFoundException {

        Category catEntity = categoryRepository.findByTitle(title)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Categoria titulo: %s Not Found", title)));

        return categoryMapper.mapToDto(catEntity);
    }

    /**
     * Actualizar Categoria.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional
    @Override
    public CategoryDto update(CategoryDto dto) throws ElementNotFoundException {

        categoryRepository.findById(dto.getId())
                .orElseThrow(() -> new ElementNotFoundException(String.format("Categoria con id: %s Not Found", dto.getId())));

        Category cEntity = categoryMapper.mapToEntity(dto);

        categoryRepository.save(cEntity);

        return dto;
    }

    /**
     * Eliminar Categoria.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    @Transactional
    @Override
    public void delete(Long id) throws ElementNotFoundException {

        categoryRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException
                        (String.format("Categoria con id: %s Not Found", id)));

        categoryRepository.deleteById(id);
    }

}
