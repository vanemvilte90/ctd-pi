package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.CategoryDto;
import grupo7.proyectoIntegrador.entities.Category;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CategoryMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Entity ->  mapToDto
     */
    public CategoryDto mapToDto(Category categoriaEntity) {

        log.info("*** CategoriaEntity {}", categoriaEntity);

        CategoryDto dto = modelMapper.map(categoriaEntity, CategoryDto.class);

        log.info("*** CategoriaDto {}", dto);

        return dto;
    }

    /**
     * mapToDto -> Entity
     */
    public Category mapToEntity(CategoryDto categoriaDto) {

        log.info("*** CategoriaDto Dto {}", categoriaDto);

        Category entity = modelMapper.map(categoriaDto, Category.class);

        log.info("*** Categoria Entity {}", entity);

        return entity;
    }


    /**
     * List Entity -> mapListDto
     */
    public List<CategoryDto> mapToListDto(List<Category> listCategoryEntity) {
        log.info("List<CategoryEntity>: {}", listCategoryEntity);

        List<CategoryDto> listCategoryDto = listCategoryEntity
                .stream()
                .map(categoryEntity -> mapToDto(categoryEntity))
                .collect(Collectors.toList());

        log.info("List<CategoryDto>: {}", listCategoryDto);
        return listCategoryDto;
    }

    /**
     * List Entity -> mapListDto
     */
    public List<Category> mapToListEntity(List<CategoryDto> listCategoryDto) {
        log.info("List<CategoryDto>: {}", listCategoryDto);

        List<Category> listCategoryEntity = listCategoryDto
                .stream()
                .map(categoryDto -> mapToEntity(categoryDto))
                .collect(Collectors.toList());

        log.info("List<CategoryEntity>: {}", listCategoryEntity);
        return listCategoryEntity;
    }
}
