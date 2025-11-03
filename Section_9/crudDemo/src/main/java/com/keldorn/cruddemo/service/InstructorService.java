package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.InstructorDto;
import com.keldorn.cruddemo.domain.entity.Instructor;

public interface InstructorService {

    InstructorDto findById(Long id);
    InstructorDto save(Instructor instructor);
    void deleteById(Long id);
}
