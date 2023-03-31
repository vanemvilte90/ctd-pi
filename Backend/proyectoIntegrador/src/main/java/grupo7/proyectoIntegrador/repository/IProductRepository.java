package grupo7.proyectoIntegrador.repository;

import grupo7.proyectoIntegrador.entities.Product;
import jdk.jfr.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {


    /**
     * Usando JPA Named Queries
     *
     * @param name
     * @return
     */
    Optional<Product> findByName(String name);


    /**
     * Obtener Producto pot city.
     *
     * @param name
     * @return
     */
    @Query("select p from Product p where p.city.name like %?1%")
    List<Product> findProductByCity(String name);


    /**
     * Obtener Producto por Category.
     */
    @Query("select p from Product p where p.category.title like ?1")
    List<Product> findProductByCategory(String title);

    /**
     * Filtrar por ciudad y fechas de reserva
     */
    //@Query("SELECT distinct p FROM Product p left join p.reservations re WHERE  re.startTime not between :startTime and :finalDate and re.finalDate not between :startTime and :finalDate and p.city.name like :name or (re is null and p.city.name like :name)")
    //List<Product> findProductByDateAndCity(@Param("startTime") LocalDate startTime, @Param("finalDate") LocalDate finalDate, @Param("name") String name);

    /**
     * Fitro por fechas de reserva
     */
    //@Query("SELECT distinct p FROM Product p left join p.reservations re WHERE  re.startTime not between :startTime and :finalDate and re.finalDate not between :startTime and :finalDate or (re is null)")
    //List<Product> findProductByDate(@Param("startTime") LocalDate startTime, @Param("finalDate") LocalDate finalDate);
}
