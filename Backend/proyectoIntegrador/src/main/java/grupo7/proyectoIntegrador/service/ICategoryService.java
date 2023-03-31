package grupo7.proyectoIntegrador.service;


import grupo7.proyectoIntegrador.dto.CategoryDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;

import java.util.List;

public interface ICategoryService {

    /**
     * Crear Categoria
     *
     * @param dto
     * @return
     */
    CategoryDto createCategory(CategoryDto dto) throws ExistingException;

    /**
     * Listar todas las categorias.
     */
    List<CategoryDto> getAllCategory();


    /**
     * Buscar categoria por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    CategoryDto findById(Long id) throws ElementNotFoundException;


    /**
     * Buscar categoria por Titulo.
     *
     * @param title
     * @return
     * @throws ElementNotFoundException
     */
    CategoryDto findByTitle(String title) throws ElementNotFoundException;


    /**
     * Actualizar Categoria.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    CategoryDto update(CategoryDto dto) throws ElementNotFoundException;


    /**
     * Eliminar Categoria.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    void delete(Long id) throws ElementNotFoundException;

}
