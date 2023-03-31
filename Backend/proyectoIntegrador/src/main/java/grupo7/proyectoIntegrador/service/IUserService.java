package grupo7.proyectoIntegrador.service;

import grupo7.proyectoIntegrador.dto.UserDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;

import java.util.List;

public interface IUserService {


    /**
     * Obtener usuario por email.
     *
     * @param mail
     * @return
     */
    UserDto findUserByMail(String mail) throws ElementNotFoundException;

    /**
     * Crear Usuarios
     *
     * @param dto
     * @return
     */
    UserDto createUser(UserDto dto) throws ExistingException, ElementNotFoundException;

    /**
     * Listar todas las Usuarioses.
     */
    List<UserDto> getAllUser();


    /**
     * Buscar Usuarios por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    UserDto findById(Long id) throws ElementNotFoundException;


    /**
     * Buscar Usuarios por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    UserDto findByName(String name) throws ElementNotFoundException;


    /**
     * Actualizar Usuarios.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    UserDto update(UserDto dto) throws ElementNotFoundException;


    /**
     * Eliminar Usuarios.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    void delete(Long id) throws ElementNotFoundException;
}
