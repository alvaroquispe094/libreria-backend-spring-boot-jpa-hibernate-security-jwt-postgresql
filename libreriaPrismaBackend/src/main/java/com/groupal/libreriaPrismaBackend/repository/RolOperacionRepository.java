package com.groupal.libreriaPrismaBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.groupal.libreriaPrismaBackend.entity.RolOperacion;

@Repository
public interface RolOperacionRepository extends JpaRepository<RolOperacion, Long> ,QuerydslPredicateExecutor<RolOperacion> {
    Optional<RolOperacion> findByRolId(Long role_id);

//	Optional<RolOperacion> findAll(BooleanExpression predicate, Order sort);


//    Iterable<RolOperacion> findAllPredicate(BooleanExpression predicate) {}
    
//    <S> Optional<RolOperacion> findAllPredicate(BooleanExpression predicate);
    
    
}
