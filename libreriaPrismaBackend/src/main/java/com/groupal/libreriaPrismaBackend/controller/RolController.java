package com.groupal.libreriaPrismaBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupal.libreriaPrismaBackend.entity.Rol;
import com.groupal.libreriaPrismaBackend.service.RolService;

@CrossOrigin(origins = "${angular.cross-origin}")
@RestController
@RequestMapping("/api/admin")
public class RolController {
	
	@Autowired
    private RolService rolService;

	@GetMapping("/roles")
    public ResponseEntity < List<Rol> > getAllUsuarios() {
        return ResponseEntity.ok().body(rolService.getAllRoles());
    }

}
