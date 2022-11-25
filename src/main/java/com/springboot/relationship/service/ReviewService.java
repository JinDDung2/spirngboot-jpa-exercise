package com.springboot.relationship.service;

import com.springboot.relationship.Repository.HospitalRepository;
import com.springboot.relationship.Repository.ReviewRepository;
import com.springboot.relationship.domain.Hospital;
import com.springboot.relationship.domain.Review;
import com.springboot.relationship.domain.dto.ReviewReqDto;
import com.springboot.relationship.domain.dto.ReviewResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ReviewResDto getOne(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()
                -> new RuntimeException("해당 아이디가 없습니다."));
        ReviewResDto response = ReviewResDto.from(review);
        return response;
    }

    public List<ReviewResDto> getAll(Pageable pageable) {
        Page<Review> pages = reviewRepository.findAll(pageable);
        List<ReviewResDto> response = pages.stream().map((review) ->
                ReviewResDto.from(review)).collect(Collectors.toList());
        return response;
    }

    public List<ReviewResDto> getAllByHospital(Long hospitalId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Id가 없습니다."));

        List<ReviewResDto> response = reviewRepository.findByHospital(hospital).stream().map((review ->
                        ReviewResDto.builder()
                                .title(review.getTitle())
                                .content(review.getContent())
                                .patientName(review.getPatientName())
                                .hospitalName(review.getHospital().getName())
                                .build()))
                .collect(Collectors.toList());
        return response;
    }


}
