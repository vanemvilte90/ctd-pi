package grupo7.proyectoIntegrador.controller;

import grupo7.proyectoIntegrador.dto.UserDto;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.service.impl.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Instancia User Service
     */
    private final UserServiceImp userService;

    /**
     * INyeccion de dependencia por constructor.
     *
     * @param userService
     */
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    /**
     * Crear user.
     *
     * @param user
     * @return
     * @throws ExistingException
     */
    @PostMapping
    public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto user) throws ExistingException, ElementNotFoundException {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    /**
     * Listar todas las users.
     *
     * @return List<UserDto>
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAlluser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    /**
     * Buscar user por Id.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDto> finduserById(@PathVariable Long id) throws ElementNotFoundException {
        return ResponseEntity.ok(userService.findById(id));
    }

    /**
     * Buscar user por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<UserDto> finduserByName(@PathVariable String name) throws ElementNotFoundException {
        return ResponseEntity.ok(userService.findByName(name));
    }

    /**
     * Buscar user por Name.
     *
     * @param email
     * @return
     * @throws ElementNotFoundException
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> finduserByEmail(@PathVariable String email) throws ElementNotFoundException {
        return ResponseEntity.ok(userService.findUserByMail(email));
    }

    /**
     * Actualizar user.
     *
     * @param user
     * @return
     * @throws ElementNotFoundException
     */
    @PostMapping("/actualizar")
    public ResponseEntity<UserDto> updateuser(@Valid @RequestBody UserDto user) throws ElementNotFoundException {
        return ResponseEntity.ok(userService.update(user));
    }

    /**
     * Eliminar user.
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteuser(@PathVariable Long id) throws ElementNotFoundException {
        userService.delete(id);
        return ResponseEntity.ok("Se elimino la user con id: " + id);
    }
}
