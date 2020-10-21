package com.groupal.libreriaPrismaBackend.service;

import java.util.List;

import com.groupal.libreriaPrismaBackend.dto.UsuarioDto;
import com.groupal.libreriaPrismaBackend.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario createUsuario(UsuarioDto usuario);

    public UsuarioDto updateUsuario(UsuarioDto usuario);
    
    public List<Usuario> getAllUsuarios();
    
    public UsuarioDto getUsuarioById(Integer usuarioId);
    
    public void deleteUsuario(Integer usuarioId);

}
