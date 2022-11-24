package com.springboot.relationship.Repository;

import com.springboot.relationship.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
