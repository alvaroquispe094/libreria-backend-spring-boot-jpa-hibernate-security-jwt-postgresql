package com.groupal.libreriaPrismaBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.groupal.libreriaPrismaBackend.entity.Operacion;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Long> ,QuerydslPredicateExecutor<Operacion> {

    
}
