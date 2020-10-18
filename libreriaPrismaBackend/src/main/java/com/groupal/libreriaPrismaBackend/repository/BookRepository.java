package com.groupal.libreriaPrismaBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.groupal.libreriaPrismaBackend.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>, QuerydslPredicateExecutor<Book>{

}
