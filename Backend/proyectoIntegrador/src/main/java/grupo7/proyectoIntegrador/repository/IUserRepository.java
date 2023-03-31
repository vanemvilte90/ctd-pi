package grupo7.proyectoIntegrador.repository;

import grupo7.proyectoIntegrador.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {


    /**
     * Obtener User por Email.
     *
     * @param mail
     * @return
     */
    @Query("select u from User u where u.mail=?1")
    Optional<User> findByMail(String mail);

    /**
     * Obtener Usuario por Name.
     *
     * @param name
     * @return
     */
    Optional<User> findByName(String name);
}
