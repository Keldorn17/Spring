package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.InstructorDto;
import com.keldorn.cruddemo.domain.dto.InstructorWithCoursesDto;
import com.keldorn.cruddemo.domain.entity.Instructor;

public interface InstructorService {

    InstructorWithCoursesDto findByIdWithCourses(Long id);
    InstructorDto findById(Long id);
    InstructorWithCoursesDto save(Instructor instructor);
    void deleteById(Long id);
}
