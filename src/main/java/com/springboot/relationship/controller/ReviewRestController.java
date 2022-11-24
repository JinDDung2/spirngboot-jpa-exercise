package com.springboot.relationship.controller;

import com.springboot.relationship.Repository.ReviewRepository;
import com.springboot.relationship.domain.Review;
import com.springboot.relationship.domain.dto.ReviewReqDto;
import com.springboot.relationship.domain.dto.ReviewResDto;
import com.springboot.relationship.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("{id}/reviews")
    public ResponseEntity<ReviewResDto> createReview(@PathVariable Long id, @RequestBody ReviewReqDto reviewReqDto) {
        ReviewResDto response = reviewService.createReview(reviewReqDto);
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReviewResDto> get(@PathVariable Long id) {
        ReviewResDto response = reviewService.getOne(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewResDto>> getAll(Pageable pageable) {
        List<ReviewResDto> response = reviewService.getAll(pageable);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
