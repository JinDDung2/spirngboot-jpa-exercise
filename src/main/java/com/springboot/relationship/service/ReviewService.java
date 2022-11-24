package com.springboot.relationship.service;

import com.springboot.relationship.Repository.HospitalRepository;
import com.springboot.relationship.Repository.ReviewRepository;
import com.springboot.relationship.domain.Hospital;
import com.springboot.relationship.domain.Review;
import com.springboot.relationship.domain.dto.ReviewReqDto;
import com.springboot.relationship.domain.dto.ReviewResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewResDto createReview(ReviewReqDto reviewReqDto) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(reviewReqDto.getHospitalId());
        Review review = Review.builder()
                .title(reviewReqDto.getTitle())
                .content(reviewReqDto.getContent())
                .patientName(reviewReqDto.getPatientName())
                .hospital(optionalHospital.get())
                .build();
        reviewRepository.save(review);
        ReviewResDto response = ReviewResDto.from(review);
        return response;
    }

}
