package com.groupal.libreriaPrismaBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.groupal.libreriaPrismaBackend.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>, QuerydslPredicateExecutor<Rol> {
//    Optional<Rol> findByRoles(RolNombre rolNombre);
    Optional<Rol> findByRolNombre(String rolNombre);
}
