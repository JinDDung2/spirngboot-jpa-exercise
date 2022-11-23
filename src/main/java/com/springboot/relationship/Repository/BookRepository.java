package com.springboot.relationship.Repository;

import com.springboot.relationship.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface BookRepository extends JpaRepository<Book, Long> {
     Page<Book> findAll(Pageable pageable);
}
