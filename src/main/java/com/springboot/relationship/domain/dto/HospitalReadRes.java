package com.springboot.relationship.domain.dto;

import com.springboot.relationship.domain.Hospital;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalReadRes {

    private String hospitalName;
    private String roadNameAddress;
    private List<ReviewResDto> reviews;

    public static HospitalReadRes from(Hospital hospital) {
        return HospitalReadRes.builder()
                .hospitalName(hospital.getName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(hospital.getReviews().stream()
                        .map(review -> ReviewResDto.from(review)).collect(Collectors.toList()))
                        .build();
    }
}
