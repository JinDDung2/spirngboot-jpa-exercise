package com.springboot.relationship.controller;

import com.springboot.relationship.domain.Hospital;
import com.springboot.relationship.domain.dto.HospitalReadRes;
import com.springboot.relationship.domain.dto.ReviewReqDto;
import com.springboot.relationship.domain.dto.ReviewResDto;
import com.springboot.relationship.service.HospitalService;
import com.springboot.relationship.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class HospitalRestController {

    private final ReviewService reviewService;
    private final HospitalService hospitalService;

    /** 리뷰 생성 */
    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewResDto> createReview(@PathVariable Long id, @RequestBody ReviewReqDto reviewReqDto) {
        ReviewResDto response = reviewService.createReview(reviewReqDto);
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(response);
    }

    /** 특정 병원 리뷰 전체조회*/
    @GetMapping("/{hospitalId}/reviews")
    public ResponseEntity<List<ReviewResDto>> getAllByHospital(@PathVariable Long hospitalId) {
        List<ReviewResDto> response = reviewService.getAllByHospital(hospitalId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    /** 리뷰 보이는 병원 조회 */
    @GetMapping("/{id}")
    public ResponseEntity<HospitalReadRes> hospital(@PathVariable Long id) {
        Hospital hospital = hospitalService.findById(id);
        HospitalReadRes response = HospitalReadRes.from(hospital);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
