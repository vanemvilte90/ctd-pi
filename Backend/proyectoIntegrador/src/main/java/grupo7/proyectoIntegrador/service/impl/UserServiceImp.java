package grupo7.proyectoIntegrador.service.impl;

import grupo7.proyectoIntegrador.service.IProductService;
import grupo7.proyectoIntegrador.service.IUserService;
import grupo7.proyectoIntegrador.dto.UserDto;
import grupo7.proyectoIntegrador.entities.Role;
import grupo7.proyectoIntegrador.entities.User;
import grupo7.proyectoIntegrador.exception.ElementNotFoundException;
import grupo7.proyectoIntegrador.exception.ExistingException;
import grupo7.proyectoIntegrador.mapper.ProductMapper;
import grupo7.proyectoIntegrador.mapper.UserMapper;
import grupo7.proyectoIntegrador.repository.IRoleRepository;
import grupo7.proyectoIntegrador.repository.IUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements IUserService, UserDetailsService {

    /**
     * Instancia Bcrypt
     */
    private final BCryptPasswordEncoder bcryp;
    /**
     * Instancia user Repository.
     */
    private final IUserRepository userRepository;

    /**
     * Instancia User Mapper.
     */
    private final UserMapper userMapper;

    /**
     * Instancia Product Mapper.
     */
    private final ProductMapper productMapper;

    /**
     * Instancia Product Repository.
     */
    private final IProductService productService;

    /**
     * Instancia Product Service
     */
    private final IRoleRepository roleRepository;

    public UserServiceImp(BCryptPasswordEncoder bcryp, IUserRepository userRepository, IRoleRepository roleRepository, UserMapper userMapper, ProductMapper productMapper, IProductService productService) {
        this.bcryp = bcryp;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.productService = productService;
    }


    /**
     * Obtener usuario por email.
     *
     * @param mail
     * @return
     */
    @Override
    public UserDto findUserByMail(String mail) throws ElementNotFoundException {

        User user = userRepository.findByMail(mail)
                .orElseThrow(() -> new ElementNotFoundException(String.format("User con mail: %s Not Found", mail)));

        return userMapper.mapToDto(user);
    }

    /**
     * Crear Usuarios
     *
     * @param userDto
     * @return
     */
    @Override
    public UserDto createUser(UserDto userDto) throws ExistingException {

        if (userRepository.findByName(userDto.getName()).isPresent()) {
            throw new ExistingException(String.format("User name: %s ya existe en BD", userDto.getName()));
        }


        Role roleResponse = roleRepository.findById(2L).get();


        User u = userMapper.mapToEntity(userDto);
        u.setRole(roleResponse);
        u.setPassword(bcryp.encode(u.getPassword()));

        User usuario = userRepository.save(u);


        return userMapper.mapToDto(usuario);
    }

    /**
     * Listar todas las Usuarioses.
     */
    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();

        return userMapper.mapToListDto(users);
    }

    /**
     * Buscar Usuarios por Id
     *
     * @param id
     * @return
     * @throws ElementNotFoundException
     */
    @Override
    public UserDto findById(Long id) throws ElementNotFoundException {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("User con id: %s Not Found", id)));

        return userMapper.mapToDto(user);
    }

    /**
     * Buscar Usuarios por Name.
     *
     * @param name
     * @return
     * @throws ElementNotFoundException
     */
    @Override
    public UserDto findByName(String name) throws ElementNotFoundException {

        User user = userRepository.findByName(name)
                .orElseThrow(() -> new ElementNotFoundException(String.format("User con name: %s Not Found", name)));

        return userMapper.mapToDto(user);
    }

    /**
     * Actualizar Usuarios.
     *
     * @param dto
     * @return
     * @throws ElementNotFoundException
     */
    @Override
    public UserDto update(UserDto dto) throws ElementNotFoundException {

        userRepository.findById(dto.getId())
                .orElseThrow(() -> new ElementNotFoundException((String.format("User con id: %s Not Found", dto.getId()))));

        User uEntity = userMapper.mapToEntity(dto);

        userRepository.save(uEntity);

        return dto;

    }

    /**
     * Eliminar Usuarios.
     *
     * @param id
     * @throws ElementNotFoundException
     */
    @Override
    public void delete(Long id) throws ElementNotFoundException {

        userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException
                        (String.format("User con id: %s Not Found", id)));

        userRepository.deleteById(id);
    }

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User usuario = userRepository.findByMail(username).orElse(null);

        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(usuario.getRole().getName()));

        UserDetails userDetails = new org.springframework.security.core.userdetails
                .User(usuario.getMail(), usuario.getPassword(), roles);

        return userDetails;
    }
}
