package grupo7.proyectoIntegrador.facade;


import grupo7.proyectoIntegrador.dto.ProductDto;
import grupo7.proyectoIntegrador.service.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ProductFacadeService {

    /**
     * Instancia ProductService
     */
    private final IProductService productService;

    /**
     * Instancia category Service
     */
    private final ICategoryService categoryService;

    /**
     * Instancia City Service
     */
    private final ICityService cityService;

    /**
     * nstancia Image Service
     */
    private final IImageService imageService;

    /**
     * Instancia Feature Service
     */
    private final IFeatureService featureService;


    /**
     * Inyeccion de dependencias por constructor.
     *
     * @param productService
     * @param categoryService
     * @param cityService
     * @param imageService
     * @param featureService
     */
    public ProductFacadeService(IProductService productService, ICategoryService categoryService, ICityService cityService, IImageService imageService, IFeatureService featureService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.cityService = cityService;
        this.imageService = imageService;
        this.featureService = featureService;

    }


    /**
     * Obtener Producto por Ciudad
     *
     * @param cityName
     * @return
     */
    public List<ProductDto> getProductsByCity(String cityName) {
        return productService.findProductByCity(cityName);
    }

    /**
     * Obtener Producto por Ciudad
     *
     * @param title
     * @return
     */
    public List<ProductDto> getProductsByCategoryTitle(String title) {
        return productService.findProductCategory(title);
    }

    /**
     * getRandomProducts (4)
     *
     * @return
     */
    public List<ProductDto> getRandomProducts() {

        List<ProductDto> responseListDto = new ArrayList<>();

        List<ProductDto> completeList = productService.getAllProduct();

        if (completeList != null) {
            int i = 0, cantidad = 4, rango = completeList.size();

            int arreglo[] = new int[cantidad];

            arreglo[i] = (int) (Math.random() * rango);

            for (i = 1; i < cantidad; i++) {
                arreglo[i] = (int) (Math.random() * rango);

                for (int j = 0; j < i; j++) {
                    if (arreglo[i] == arreglo[j]) {
                        i--;
                    }
                }
            }
            for (int k = 0; k < 4; k++) {
                responseListDto.add(completeList.get(arreglo[k]));
            }

        }

        return responseListDto;
    }

    /**
     * Filtrar Producto por ciudad y fechas
     */
    public List<ProductDto> filterProductByDateAndCity(LocalDate startDate, LocalDate finalDate, String nameCity) {

        return productService.findProductByDateAndCity(startDate, finalDate, nameCity);
    }

    /**
     * Filtrar Producto por fechas.
     */
    public List<ProductDto> filterProductByDate(LocalDate startDate, LocalDate finalDate) {

        return productService.findProductByDate(startDate, finalDate);
    }
}
