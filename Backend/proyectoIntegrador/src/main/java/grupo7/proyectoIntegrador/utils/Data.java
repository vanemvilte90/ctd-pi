package grupo7.proyectoIntegrador.utils;

import grupo7.proyectoIntegrador.dto.CategoryDto;
import grupo7.proyectoIntegrador.entities.Category;

import java.util.Arrays;
import java.util.List;

public class Data {

    /**
     * Data para la Category entity.
     */
    public static final Category CATEGORY_SPORT = new Category(null, "Sport", "Todo deporte", "urlimg");
    public static final Category CATEGORY_OFFICE = new Category(null, "Office", "Todo Oficina", "urlimg");

    public static List<Category> CATEGORY_LIST = Arrays.asList(
            new Category(1L, "Sport", "Todo deporte", "urlimg"),
            new Category(2L, "Office", "Todo Oficina", "urlimg")
    );
    /**
     * Data para la Category dto.
     */
    public static final CategoryDto CATEGORY_SPORT_DTO = new CategoryDto(null, "Sport", "Todo deporte", "urlimg");
    public static final CategoryDto CATEGORY_OFFICE_DTO = new CategoryDto(null, "Office", "Todo Oficina", "urlimg");

    public static List<CategoryDto> CATEGORY_LIST_DTO = Arrays.asList(
            new CategoryDto(1L, "Sport", "Todo deporte", "urlimg"),
            new CategoryDto(2L, "Office", "Todo Oficina", "urlimg")
    );

}
