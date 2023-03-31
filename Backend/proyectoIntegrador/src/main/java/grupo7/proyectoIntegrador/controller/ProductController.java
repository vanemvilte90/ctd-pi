package grupo7.proyectoIntegrador.controller;

import grupo7.proyectoIntegrador.dto.ProductDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class    ProductController {


    /**
     * Instancia de Product Service
     */
    private final IProductService productService;

    /**
     * Inyeccion de dependencias por constructor
     *
     * @param productService
     */
    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    /**
     * Crear Producto
     *
     * @param dto
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<ProductDto> createProducto(@Valid @RequestBody ProductDto dto) throws ExistingException, ElementNotFoundException {
        log.info("Producto Dto: {}", dto);

        ProductDto prodDto = productService.createProducto(dto);
        log.info("Producto response Dto: {}", prodDto);

        return new ResponseEntity<>(prodDto, HttpStatus.CREATED);
    }

    /**
     * Listar todas los productos.
     */
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    /**
     * Buscar producto por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) throws ElementNotFoundException {
        return ResponseEntity.ok(productService.findById(id));
    }


    /**
     * Buscar producto por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/nombre/{name}")
    public ResponseEntity<ProductDto> findByName(@PathVariable String name) throws ElementNotFoundException {
        return ResponseEntity.ok(productService.findByName(name));
    }

    /**
     * Actualizar Producto.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/actualizar")
    ResponseEntity<ProductDto> update(@Valid @RequestBody ProductDto dto) throws ElementNotFoundException {
        return ResponseEntity.ok(productService.update(dto));
    }


    /**
     * Eliminar Producto.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    ResponseEntity<String> delete(@PathVariable Long id) throws ElementNotFoundException {
        productService.delete(id);
        return ResponseEntity.ok("Se elimino el producto con id: " + id);
    }
}
