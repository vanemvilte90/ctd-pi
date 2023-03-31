package grupo7.proyectoIntegrador.repository;

import grupo7.proyectoIntegrador.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {


    /**
     * Obtener Role por Name.
     *
     * @param name
     * @return
     */
    Optional<Role> findByName(String name);

    Optional<Role> findById(Long id);
}
