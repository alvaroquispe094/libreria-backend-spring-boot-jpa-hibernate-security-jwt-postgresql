package com.groupal.libreriaPrismaBackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupal.libreriaPrismaBackend.exception.ResourceNotFoundException;
import com.groupal.libreriaPrismaBackend.entity.UsuarioRol;
import com.groupal.libreriaPrismaBackend.repository.UsuarioRolRepository;
import com.querydsl.core.types.dsl.BooleanExpression;


@Service
public class UsuarioRolService {
	
	@Autowired
    UsuarioRolRepository usuarioRolRepository;
	
	public UsuarioRol createUsuario(UsuarioRol usuarioRol) {
    	UsuarioRol usuarioRolDto = usuarioRolRepository.save(usuarioRol); // se guarda el usuarioRol y se obtiene el result para obtener el id
    	if (usuarioRolDto != null) {
    		
    		return usuarioRolDto;
    		
    	}else {
    		throw new ResourceNotFoundException("Record not saved");
    	}
	}
	
	public UsuarioRol getUsuarioRolById(Integer usuarioRolId) {
		 Optional<UsuarioRol> usuarioRolDb = this.usuarioRolRepository.findById(usuarioRolId);

	        if (usuarioRolDb.isPresent()) {
	            return usuarioRolDb.get();
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + usuarioRolId);
	        }
	}
	
	public UsuarioRol updateUsuarioRol(UsuarioRol usuarioRol) {
		 Optional<UsuarioRol> usuarioRolDb = this.usuarioRolRepository.findById(usuarioRol.getId());

	        if (usuarioRolDb.isPresent()) {
	            UsuarioRol usuarioRolUpdate = usuarioRolDb.get();
	            usuarioRolUpdate.setId(usuarioRol.getId());
	            usuarioRolUpdate.setUsuario(usuarioRol.getUsuario());
	            usuarioRolUpdate.setRol(usuarioRol.getRol());
	            usuarioRolUpdate.setActivo(usuarioRol.getActivo());
	            usuarioRolRepository.save(usuarioRolUpdate);
	            return usuarioRolUpdate;
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + usuarioRol.getId());
	        }
	}
	
	public UsuarioRol getUsuarioRolByUserId(BooleanExpression predicate){

		return usuarioRolRepository.findOne(predicate).get();
		
	}
}
