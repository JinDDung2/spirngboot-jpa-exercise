package com.springboot.relationship.Repository;

import com.springboot.relationship.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
