package grupo7.proyectoIntegrador.repository;

import grupo7.proyectoIntegrador.entities.Category;
import grupo7.proyectoIntegrador.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {

    /**
     * Usando JPA Named Queries
     *
     * @param name
     * @return
     */
    Optional<City> findByName(String name);



}
