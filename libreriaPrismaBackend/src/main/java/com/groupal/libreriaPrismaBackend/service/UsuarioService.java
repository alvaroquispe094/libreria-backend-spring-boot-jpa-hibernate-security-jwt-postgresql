package com.groupal.libreriaPrismaBackend.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.groupal.libreriaPrismaBackend.dto.UsuarioDto;
import com.groupal.libreriaPrismaBackend.entity.Book;
import com.groupal.libreriaPrismaBackend.entity.QUsuarioRol;
import com.groupal.libreriaPrismaBackend.entity.Rol;
import com.groupal.libreriaPrismaBackend.entity.Usuario;
import com.groupal.libreriaPrismaBackend.entity.UsuarioRol;
import com.groupal.libreriaPrismaBackend.exception.ResourceNotFoundException;
import com.groupal.libreriaPrismaBackend.repository.UsuarioRepository;
import com.groupal.libreriaPrismaBackend.repository.UsuarioRolRepository;
import com.groupal.libreriaPrismaBackend.utils.ObjectMapperUtils;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	PasswordEncoder encoder;
	
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    UsuarioRolRepository usuarioRolRepository;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    UsuarioRolService usuarioRolService;

    public Optional<Usuario> getByNombreUsuario(String username){
        return usuarioRepository.findByUsuario(username);
    }

    public boolean existePorNombre(String nu){
        return usuarioRepository.existsByUsuario(nu);
    }

    public  boolean existePorEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }


    @Override
	public UsuarioDto createUsuario(UsuarioDto usuarioDto) {
    	
    	try {
    		Usuario usuario = ObjectMapperUtils.map(usuarioDto, Usuario.class);
    		
    		//debo encriptar la password
    		usuario.setPassword(encoder.encode(usuarioDto.getPassword()));
    		
    		//guardo el unuevo ususario
			Usuario usuarioResponse = this.usuarioRepository.save(usuario);
			
			if (usuarioResponse != null) {
	    		//obtengo el rol del usuario
	    		Rol rol = rolService.getById(usuarioDto.getRol().getId());
	    		
	    		//guardo el rol para el usuario
	    		UsuarioRol usuarioRol = new UsuarioRol();
	    		usuarioRol.setUsuario(usuarioResponse);
	    		usuarioRol.setRol(rol);
	    		usuarioRol.setActivo(true);
	    		usuarioRolRepository.save(usuarioRol);
	    		
//	    		return usuarioResponse;
	    		
	    	}else {
	    		throw new ResourceNotFoundException("Record not saved");
	    	}
			
			usuarioDto.setMensaje("El usuario ha sido creado de manera exitosa");
		    return usuarioDto;
	    
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
//		LOG.error("Error al grabar la información.", e);
			throw new ServiceException("Error al grabar la información.");
		}
    	
    	
    	//seteando usuario
//    	Usuario usuario = new Usuario();
//    	usuario.setNombre(usuarioDto.getNombre());
//    	usuario.setApellido(usuarioDto.getApellido());
//    	usuario.setEmail(usuarioDto.getEmail());
//    	usuario.setUsuario(usuarioDto.getUsuario());
//    	usuario.setPassword(encoder.encode(usuarioDto.getPassword()));
//    	usuario.setDireccion(usuarioDto.getDireccion());
//    	usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
//    	usuario.setDocumento(usuarioDto.getDocumento());
//    	usuario.setActivo(true);
//    	Usuario usuarioResponse = usuarioRepository.save(usuario); // se guarda el usuario y se obtiene el result para obtener el id
//    	
//    	if (usuarioResponse != null) {
//    		//obtengo el rol del usuario
//    		Rol rol = rolService.getById(usuarioDto.getRol().getId());
//    		
//    		//guardo el rol para el usuario
//    		UsuarioRol usuarioRol = new UsuarioRol();
//    		usuarioRol.setUsuario(usuarioResponse);
//    		usuarioRol.setRol(rol);
//    		usuarioRolRepository.save(usuarioRol);
//    		
//    		return usuarioResponse;
//    		
//    	}else {
//    		throw new ResourceNotFoundException("Record not saved");
//    	}
	}

	@Override
	public UsuarioDto updateUsuario(UsuarioDto usuarioDto) {
		//obtengo el usuario para
		Optional<Usuario> usuario = this.usuarioRepository.findById(usuarioDto.getId());

        if (usuario.isPresent()) {
        	
        	//setea en el usuario los datos del Dto y guardo
    		usuario.get().setId(usuarioDto.getId());
    		usuario.get().setNombre(usuarioDto.getNombre());
    		usuario.get().setApellido(usuarioDto.getApellido());
    		usuario.get().setEmail(usuarioDto.getEmail());
    		usuario.get().setUsuario(usuarioDto.getUsuario());
    		usuario.get().setPassword(usuarioDto.getPassword());
    		usuario.get().setDireccion(usuarioDto.getDireccion());
    		usuario.get().setFechaNacimiento(usuarioDto.getFechaNacimiento());
    		usuario.get().setDocumento(usuarioDto.getDocumento());
    		usuario.get().setActivo(usuarioDto.getActivo());
        	//guardo los nuevos datos del
        	usuarioRepository.save(usuario.get());
        	
        	//setea en el rol del Dto en usuarioRol y actualiza si se cambio el rol
        	Rol rol = rolService.getById(usuarioDto.getRol().getId());
        	
        	BooleanExpression consulta = QUsuarioRol.usuarioRol.id.ne(0);
    		consulta = consulta.and(QUsuarioRol.usuarioRol.usuario.id.eq(usuario.get().getId()));
        	UsuarioRol usuarioRol = usuarioRolService.getUsuarioRolByUserId(consulta);
        	usuarioRol.setRol(rol);
        	usuarioRolService.updateUsuarioRol(usuarioRol);
        	
        	return usuarioDto;
        } else {
            throw new ResourceNotFoundException("Record not found for update with id : " + usuarioDto.getId());
        }
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		
		
		return this.usuarioRepository.findAll();
	}

	@Override
	public UsuarioDto getUsuarioById(Integer usuarioId) {
		//obtiene la entidad usuario con sus datos
		Optional<Usuario> usuario = this.usuarioRepository.findById(usuarioId);

        if (usuario.isPresent()) {
        	//setea en el Dto los datos del usuario
        	UsuarioDto usuarioDto = new UsuarioDto();
        	usuarioDto.setId(usuario.get().getId());
        	usuarioDto.setNombre(usuario.get().getNombre());
        	usuarioDto.setApellido(usuario.get().getApellido());
        	usuarioDto.setEmail(usuario.get().getEmail());
        	usuarioDto.setUsuario(usuario.get().getUsuario());
        	usuarioDto.setPassword(usuario.get().getPassword());
        	usuarioDto.setDireccion(usuario.get().getDireccion());
        	usuarioDto.setFechaNacimiento(usuario.get().getFechaNacimiento());
        	usuarioDto.setDocumento(usuario.get().getDocumento());
        	usuarioDto.setActivo(usuario.get().getActivo());
        	
        	//setea en el Dto el rol
        	BooleanExpression consulta = QUsuarioRol.usuarioRol.id.ne(0);
    		consulta = consulta.and(QUsuarioRol.usuarioRol.usuario.id.eq(usuarioId));
        	UsuarioRol usuarioRol = usuarioRolService.getUsuarioRolByUserId(consulta);
        	usuarioDto.setRol(usuarioRol.getRol());
        	
            return usuarioDto;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + usuarioId);
        }
	}

	@Override
	public void deleteUsuario(Integer usuarioId) {
		Optional<Usuario> usuarioDb = this.usuarioRepository.findById(usuarioId);

        if (usuarioDb.isPresent()) {
            this.usuarioRepository.delete(usuarioDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + usuarioId);
        }
		
	}
}

