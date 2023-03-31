package grupo7.proyectoIntegrador.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import grupo7.proyectoIntegrador.dto.ProductDto;
import grupo7.proyectoIntegrador.facade.ProductFacadeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductFacadeController {

    /**
     * INstancia Product Facade Service.
     */
    private final ProductFacadeService prodfacade;

    /**
     * Inyeccion de dependencias por constructor.
     *
     * @param prodfacade
     */
    public ProductFacadeController(ProductFacadeService prodfacade) {
        this.prodfacade = prodfacade;
    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<ProductDto>> getAllProductsByCity(@PathVariable String cityName) {
        return ResponseEntity.ok(prodfacade.getProductsByCity(cityName));
    }

    /**
     * Buscar Producto por categoria
     */
    @GetMapping("/title/{title}")
    public ResponseEntity<List<ProductDto>> findProductCategory(@PathVariable String title) {
        return ResponseEntity.ok(prodfacade.getProductsByCategoryTitle(title));
    }

    /**
     * getRandomProducts (3)
     *
     * @return
     */
    @GetMapping("/randoms")
    public ResponseEntity<List<ProductDto>> RandomProducts() {
        return ResponseEntity.ok(prodfacade.getRandomProducts());
    }


    /**
     * Filter by city and dates.
     *
     * @param startDate
     * @param finalDate
     * @param cityName
     * @return
     */
    @GetMapping("/filtercitydate")
    public ResponseEntity<List<ProductDto>> filterProductByDateAndCity(@RequestParam("startDate")
                                                                       @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
                                                                       @RequestParam("finalDate")
                                                                       @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate finalDate,
                                                                       @RequestParam("cityName") String cityName) {
        return new ResponseEntity<>(prodfacade.filterProductByDateAndCity(startDate, finalDate, cityName), HttpStatus.OK);

    }

    /**
     * Filter by dates.
     *
     * @param startDate
     * @param finalDate
     * @return
     * @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
     */
    @GetMapping("/filterbydate")
    public ResponseEntity<List<ProductDto>> filterProductByDate(@RequestParam("startDate")
                                                                @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
                                                                @RequestParam("finalDate")
                                                                @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate finalDate) {
        return new ResponseEntity<>(prodfacade.filterProductByDate(startDate, finalDate), HttpStatus.OK);

    }
}
