package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.instructor.InstructorDetailResponse;
import com.keldorn.cruddemo.domain.entity.InstructorDetail;

public interface InstructorDetailService {

    InstructorDetailResponse findById(Long id);
    InstructorDetailResponse save(InstructorDetail instructorDetail);
    void deleteById(Long id);
}
