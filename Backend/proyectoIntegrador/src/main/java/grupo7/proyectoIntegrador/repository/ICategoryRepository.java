package grupo7.proyectoIntegrador.repository;

import grupo7.proyectoIntegrador.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Usando JPA Named Queries
     *
     * @param titulo
     * @return
     */
    Optional<Category> findByTitle(String titulo);
}
