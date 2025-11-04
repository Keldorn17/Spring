package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.CourseDto;
import com.keldorn.cruddemo.domain.entity.Course;

import java.util.List;

public interface CourseService {

    CourseDto findById(Long id);
    CourseDto save(Course course);
    void deleteById(Long id);
    List<CourseDto> findCoursesByInstructorId(Long instructorId);
}
