package grupo7.proyectoIntegrador.service;

import grupo7.proyectoIntegrador.dto.ProductDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface IProductService {


    /**
     * Buscar Producto pot City
     *
     * @param cityName
     * @return
     */
    List<ProductDto> findProductByCity(String cityName);


    /**
     * Buscar Producto por categoria
     *
     * @param title
     * @return
     */
    List<ProductDto> findProductCategory(String title);

    /**
     * Filtrar producto por ciudad y fechas.
     *
     * @param startDate
     * @param finalDate
     * @param cityName
     * @return
     */
    List<ProductDto> findProductByDateAndCity(LocalDate startDate, LocalDate finalDate, String cityName);

    /**
     * Filtrar Producto pot fechas
     *
     * @param startDate
     * @param finalDate
     * @return
     */
    List<ProductDto> findProductByDate(LocalDate startDate, LocalDate finalDate);


    /**
     * Crear Producto
     *
     * @param dto
     * @return
     */
    ProductDto createProducto(ProductDto dto) throws ExistingException, ElementNotFoundException;

    /**
     * Listar todas los productos.
     */
    List<ProductDto> getAllProduct();

    /**
     * Buscar producto por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    ProductDto findById(Long id) throws ElementNotFoundException;


    /**
     * Buscar producto por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    ProductDto findByName(String name) throws ElementNotFoundException;


    /**
     * Actualizar Producto.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    ProductDto update(ProductDto dto) throws ElementNotFoundException;


    /**
     * Eliminar Producto.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    void delete(Long id) throws ElementNotFoundException;

}
