package grupo7.proyectoIntegrador.repository;

import grupo7.proyectoIntegrador.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {

    //@Query("select a from Image a where a.title=?1")
    Optional<Image> findMainHousingByTitle(String title);


}
