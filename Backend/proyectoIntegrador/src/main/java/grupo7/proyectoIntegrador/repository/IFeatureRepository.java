package grupo7.proyectoIntegrador.repository;

import grupo7.proyectoIntegrador.entities.Category;
import grupo7.proyectoIntegrador.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFeatureRepository extends JpaRepository<Feature, Long> {

    /**
     * Usando JPA Named Queries
     *
     * @param name
     * @return
     */
    Optional<Feature> findByName(String name);
}
