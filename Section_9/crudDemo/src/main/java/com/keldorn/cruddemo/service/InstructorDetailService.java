package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.InstructorDetailDto;
import com.keldorn.cruddemo.domain.entity.InstructorDetail;

public interface InstructorDetailService {

    InstructorDetailDto findById(Long id);
    InstructorDetailDto save(InstructorDetail instructorDetail);
    void deleteById(Long id);
}
