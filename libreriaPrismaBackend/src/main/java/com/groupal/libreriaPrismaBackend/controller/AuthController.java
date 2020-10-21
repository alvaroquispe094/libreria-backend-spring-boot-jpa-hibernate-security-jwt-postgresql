package com.groupal.libreriaPrismaBackend.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupal.libreriaPrismaBackend.dto.UsuarioDto;
import com.groupal.libreriaPrismaBackend.entity.RolOperacion;
import com.groupal.libreriaPrismaBackend.jwtDto.JwtDTO;
import com.groupal.libreriaPrismaBackend.jwtDto.LoginUsuario;
import com.groupal.libreriaPrismaBackend.jwtDto.Mensaje;
import com.groupal.libreriaPrismaBackend.security.JwtProvider;
import com.groupal.libreriaPrismaBackend.service.RolService;
import com.groupal.libreriaPrismaBackend.service.UsuarioService;

@RestController
@CrossOrigin(origins = "${angular.cross-origin}")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    JwtProvider jwtProvider;

//    @PostMapping("/nuevo")
//    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
//        if(bindingResult.hasErrors())
//            return new ResponseEntity(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
//        if(usuarioService.existePorNombre(nuevoUsuario.getNombreUsuario()))
//            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        if(usuarioService.existePorEmail(nuevoUsuario.getEmail()))
//            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
//        Usuario usuario =
//                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
//                        passwordEncoder.encode(nuevoUsuario.getPassword()));
//        Set<String> rolesStr = nuevoUsuario.getRoles();
//        Set<Rol> roles = new HashSet<>();
//        for (String rol : rolesStr) {
//            switch (rol) {
//                case "admin":
//                    Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
//                    roles.add(rolAdmin);
//                    break;
//                default:
//                    Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
//                    roles.add(rolUser);
//            }
//        }
//        usuario.setRoles(roles);
//        usuarioService.guardar(usuario);
//        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
//    }
  
    @PostMapping("/registrar")
    public ResponseEntity < ? > registrar(@Valid @RequestBody UsuarioDto usuarioDto, BindingResult bindingResult) {
//    	Usuario usuarioDto = new Usuario();
//    	usuarioDto.setNombre(usuario.getNombre());
//    	usuarioDto.setApellido(usuario.getApellido());
//    	usuarioDto.setEmail(usuario.getEmail());
//    	usuarioDto.setUsuario(usuario.getUsuario());
//    	usuarioDto.setPassword(encoder.encode(usuario.getPassword()));
//    	usuarioDto.setDireccion(usuario.getDireccion());
//    	usuarioDto.setFechaNacimiento(usuario.getFechaNacimiento());
//    	usuarioDto.setDocumento(usuario.getDocumento());
//    	usuarioDto.setActivo(true);
    	
        return ResponseEntity.ok().body(this.usuarioService.createUsuario(usuarioDto));
    }
    
    public String logout () {
		return "/landing/logout";
	}
	
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
    	String encodedPassword = encoder.encode("456");	
    	System.out.println("pass encoded :"+encodedPassword);
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getUsuario(), loginUsuario.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
    }
    
    
    @GetMapping("/operaciones/{rol_nombre}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_RECEPTIONIST')")
    public ResponseEntity<Iterable<RolOperacion>> operaciones(@PathVariable String rol_nombre){

    	return ResponseEntity.ok().body(rolService.getOperacionesByRol(rol_nombre));
    }
}
