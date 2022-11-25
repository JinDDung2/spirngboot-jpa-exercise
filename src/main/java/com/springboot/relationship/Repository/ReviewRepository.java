package com.springboot.relationship.Repository;

import com.springboot.relationship.domain.Hospital;
import com.springboot.relationship.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAll(Pageable pageable);

    List<Review> findByHospital(Hospital hospital);
}
