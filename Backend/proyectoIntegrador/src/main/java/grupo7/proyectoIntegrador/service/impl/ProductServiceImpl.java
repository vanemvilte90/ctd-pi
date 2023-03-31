package grupo7.proyectoIntegrador.service.impl;

import grupo7.proyectoIntegrador.service.IFeatureService;
import grupo7.proyectoIntegrador.service.IProductService;
import grupo7.proyectoIntegrador.dto.ProductDto;
import grupo7.proyectoIntegrador.entities.*;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.mapper.FeatureMapper;
import grupo7.proyectoIntegrador.mapper.ProductMapper;
import grupo7.proyectoIntegrador.repository.ICategoryRepository;
import grupo7.proyectoIntegrador.repository.ICityRepository;
import grupo7.proyectoIntegrador.repository.IImageRepository;
import grupo7.proyectoIntegrador.repository.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements IProductService {


    /**
     * Instancia de Categoria Repository
     */
    private final ICategoryRepository categoryRepository;

    /**
     * Instancia de categoria Repository
     */
    private final ICityRepository cityRepository;

    /**
     * Instancia de Imagen Repository.
     */
    private final IImageRepository imgRepository;

    /**
     * Instancia de Feature Repository.
     */
    private final IFeatureService featureService;


    /**
     * Instancia de Product Repository
     */
    private final IProductRepository productRepository;

    /**
     * Instancia Product Mapper
     */
    private final ProductMapper productMapper;

    /**
     * Instancia Feature Mapper
     */
    private final FeatureMapper featureMapper;

    /**
     * Inyeccion de dependencias por Constructor.
     *
     * @param categoryRepository
     * @param cityRepository
     * @param imgRepository
     * @param featureService
     * @param productRepository
     * @param productMapper
     * @param featureMapper
     */
    public ProductServiceImpl(ICategoryRepository categoryRepository, ICityRepository cityRepository, IImageRepository imgRepository, IFeatureService featureService, IProductRepository productRepository, ProductMapper productMapper, FeatureMapper featureMapper) {
        this.categoryRepository = categoryRepository;
        this.cityRepository = cityRepository;
        this.imgRepository = imgRepository;
        this.featureService = featureService;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.featureMapper = featureMapper;
    }


    /**
     * Buscar Producto pot City
     *
     * @param cityName
     * @return
     */
    @Override
    public List<ProductDto> findProductByCity(String cityName) {
        List<ProductDto> dtos = productMapper.mapToListDto(productRepository.findProductByCity(cityName));
        return dtos;
    }

    /**
     * Buscar Producto por categoria
     *
     * @param title
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<ProductDto> findProductCategory(String title) {
        List<ProductDto> dtos = productMapper.mapToListDto(productRepository.findProductByCategory(title));
        return dtos;
    }

    /**
     * Filtrar producto por ciudad y fechas.
     *
     * @param startDate
     * @param finalDate
     * @param cityName
     * @return
     */
    @Override
    public List<ProductDto> findProductByDateAndCity(LocalDate startDate, LocalDate finalDate, String cityName) {

        List<ProductDto> listResponse = new ArrayList<>();

        List<Product> listProducts = productRepository.findAll();

        for (Product productEntity : listProducts) {
            if (productEntity.getReservations().isEmpty() && productEntity.getCity().getName().equals(cityName)) {
                listResponse.add(productMapper.mapToDto(productEntity));
            }

            for (Reservation r : productEntity.getReservations()) {
                if (finalDate.isBefore(r.getStartDate()) || startDate.isAfter(r.getFinalDate())
                        && productEntity.getCity().getName().equals(cityName)) {

                    listResponse.add(productMapper.mapToDto(productEntity));
                }
            }
        }

        return listResponse;
    }

    /**
     * Filtrar producto por fechas.
     *
     * @param startDate
     * @param finalDate
     * @return
     */
    @Override
    public List<ProductDto> findProductByDate(LocalDate startDate, LocalDate finalDate) {

        List<ProductDto> listResponse = new ArrayList<>();

        List<Product> listProducts = productRepository.findAll();

        for (Product productEntity : listProducts) {
            if (productEntity.getReservations().isEmpty()) {
                listResponse.add(productMapper.mapToDto(productEntity));
            }

            for (Reservation r : productEntity.getReservations()) {
                if (finalDate.isBefore(r.getStartDate()) || startDate.isAfter(r.getFinalDate())) {
                    listResponse.add(productMapper.mapToDto(productEntity));
                }
            }
        }
        return listResponse;
    }


    /**
     * Crear Producto
     *
     * @param dto
     * @return
     */
    @Transactional
    @Override
    public ProductDto createProducto(ProductDto dto) throws ExistingException, ElementNotFoundException {

        if (productRepository.findByName(dto.getName()).isPresent()) {
            throw new ExistingException(String.format("Producto - nombre: %s ya existe en BD", dto.getName()));
        }

        Category catResponse = categoryRepository.findByTitle(dto.getCategoryDto().getTitle()).orElse(null);

        City cityResponse = cityRepository.findByName(dto.getCityDto().getName()).orElse(null);

        log.info("Variable dto: {}", dto);
        Product prod = productMapper.mapToEntity(dto);
        prod.setRating(7);

        if (catResponse != null) {
            prod.setCategory(catResponse);
            log.info("Producto Dto: {}", dto);
        }
        if (cityResponse != null) {
            prod.setCity(cityResponse);
        }


        log.info("Variable Prod: {}", prod);
        Product entity = productRepository.save(prod);
        log.info("Producto entity: {}", entity);

        return productMapper.mapToDto(entity);

    }

    /**
     * Listar todas los productos.
     */
    @Transactional(readOnly = true)
    @Override
    public List<ProductDto> getAllProduct() {

        List<Product> prod = productRepository.findAll();

        return productMapper.mapToListDto(prod);
    }

    /**
     * Buscar producto por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public ProductDto findById(Long id) throws ElementNotFoundException {

        Product prod = productRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Producto con id: %s Not Found", id)));

        List<LocalDate> datesByDay = loggerAllReservatiosByPorductid(prod);

        ProductDto prodDto = productMapper.mapToDto(prod);
        prodDto.setListDates(datesByDay);

        return prodDto;
    }

    /**
     * Buscar producto por Name
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public ProductDto findByName(String name) throws ElementNotFoundException {

        Product prod = productRepository.findByName(name)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Producto con name: %s Not Found", name)));

        return productMapper.mapToDto(prod);
    }

    /**
     * Actualizar Producto.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    @Transactional
    @Override
    public ProductDto update(ProductDto dto) throws ElementNotFoundException {

        productRepository.findById(dto.getId())
                .orElseThrow(() -> new ElementNotFoundException(String.format("Producto con id: %s Not Found", dto.getId())));

        Product prod = productMapper.mapToEntity(dto);

        Product p = productRepository.save(prod);

        return productMapper.mapToDto(p);
    }

    /**
     * Eliminar Producto.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    @Transactional
    @Override
    public void delete(Long id) throws ElementNotFoundException {

        productRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Producto con id: %s Not Found", id)));

        productRepository.deleteById(id);
    }


    /**
     * Obtener la lista de fechas dia a dia por cada producto.
     *
     * @param prodEntity
     * @return
     */
    public List<LocalDate> loggerAllReservatiosByPorductid(Product prodEntity) {

        List<LocalDate> list = new ArrayList<>();

        LocalDate start;
        LocalDate finish;

        Product prod = prodEntity;

        for (Reservation reserv : prod.getReservations()) {
            start = reserv.getStartDate();
            finish = reserv.getFinalDate();

            while (!start.isAfter(finish)) {
                list.add(start);
                start = start.plusDays(1);
            }
        }
        return list;
    }
}
