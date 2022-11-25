package com.springboot.relationship.service;

import com.springboot.relationship.Repository.HospitalRepository;
import com.springboot.relationship.domain.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public Hospital findById(Long id) {
        Hospital hospital = hospitalRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("id가 없습니다."));
        return hospital;
    }

}
