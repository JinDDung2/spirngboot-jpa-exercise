package com.springboot.relationship.domain.dto;

import com.springboot.relationship.domain.Hospital;
import com.springboot.relationship.domain.Review;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResDto {

    private String title;
    private String content;
    private String patientName;
    private String hospitalName;

    public static ReviewResDto from(Review review) {
        return ReviewResDto.builder()
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getPatientName())
                .hospitalName(review.getHospital().getName())
                .build();
    }

}
