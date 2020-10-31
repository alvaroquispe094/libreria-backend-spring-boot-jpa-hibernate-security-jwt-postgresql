package com.groupal.libreriaPrismaBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupal.libreriaPrismaBackend.dto.UsuarioDto;
import com.groupal.libreriaPrismaBackend.entity.Usuario;
import com.groupal.libreriaPrismaBackend.service.UsuarioService;

@CrossOrigin(origins = "${angular.cross-origin}")
@RestController
@RequestMapping("/api/admin")

public class UsuarioController {
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity < List<Usuario> > getAllUsuarios() {
        return ResponseEntity.ok().body(usuarioService.getAllUsuarios());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity < UsuarioDto > getUsuarioById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(usuarioService.getUsuarioById(id));
    }

    @PostMapping("/usuario/add")
    public ResponseEntity < UsuarioDto > createUsuario(@RequestBody UsuarioDto usuarioDto) {
//        return ResponseEntity.ok().body(this.usuarioService.createUsuario(usuarioDto));
        return new ResponseEntity<>(this.usuarioService.createUsuario(usuarioDto), HttpStatus.CREATED);
    }

    @PutMapping("/usuario/update/{id}")
    public ResponseEntity < UsuarioDto > updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto) {
    	usuarioDto.setId(id);
        return ResponseEntity.ok().body(this.usuarioService.updateUsuario(usuarioDto));
    }

    @DeleteMapping("/usuario/delete/{id}")
    public HttpStatus deleteUsuario(@PathVariable Integer id) {
        this.usuarioService.deleteUsuario(id);
        return HttpStatus.OK;
    }

}
