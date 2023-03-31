package grupo7.proyectoIntegrador.controller;


import grupo7.proyectoIntegrador.dto.CategoryDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    /**
     * Instancia de Categoria Service
     */
    private final ICategoryService categoryService;

    /**
     * Inyeccion de dependencias por Constructor.
     *
     * @param categoryService
     */
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }


    /**
     * Crear Categoria.
     *
     * @param categoria
     * @return
     * @throws ExistingException
     */
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoria) throws ExistingException {
        return new ResponseEntity<>(categoryService.createCategory(categoria), HttpStatus.CREATED);
    }

    /**
     * Listar todas las categorias.
     *
     * @return List<CategoryDto>
     */
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    /**
     * Buscar categoria por Id.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable Long id) throws ElementNotFoundException {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    /**
     * Buscar categoria por Titulo.
     *
     * @param title
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/titulo/{title}")
    public ResponseEntity<CategoryDto> findCategoryByTitle(@PathVariable String title) throws ElementNotFoundException {
        return ResponseEntity.ok(categoryService.findByTitle(title));
    }

    /**
     * Actualizar Categoria.
     *
     * @param categoria
     * @return
     * @throws ElementNotFoundException
     */
    @PostMapping("/actualizar")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoria) throws ElementNotFoundException {
        return ResponseEntity.ok(categoryService.update(categoria));
    }

    /**
     * Eliminar Categoria.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws ElementNotFoundException {
        categoryService.delete(id);
        return ResponseEntity.ok("Se elimino la categoría con id: " + id);
    }


}
