package com.springboot.relationship.domain.dto;

import com.springboot.relationship.domain.Hospital;
import com.springboot.relationship.domain.Review;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewReqDto {

    private Long hospitalId;
    private String title;
    private String content;
    private String patientName;

    public Review toEntity() {
        return Review.builder()
                .id(hospitalId)
                .title(title)
                .content(content)
                .patientName(patientName)
                .build();
    }
}
