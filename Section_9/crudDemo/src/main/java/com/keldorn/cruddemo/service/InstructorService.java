package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.instructor.InstructorResponse;
import com.keldorn.cruddemo.domain.dto.instructor.InstructorRequest;
import com.keldorn.cruddemo.domain.dto.instructor.InstructorWithCoursesDto;
import com.keldorn.cruddemo.domain.entity.Instructor;

public interface InstructorService {

    InstructorWithCoursesDto findByIdWithCourses(Long id);
    InstructorResponse findById(Long id);
    InstructorWithCoursesDto save(Instructor instructor);
    void deleteById(Long id);
    InstructorWithCoursesDto update(InstructorRequest update, Long id);
}
