package com.groupal.libreriaPrismaBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.groupal.libreriaPrismaBackend.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> , QuerydslPredicateExecutor<Usuario>{
	public Optional<Usuario> findByUsuario(String username);
	 boolean existsByUsuario(String nu);
	    boolean existsByEmail(String email);
}
