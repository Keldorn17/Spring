package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.CourseResponse;
import com.keldorn.cruddemo.domain.entity.Course;

import java.util.List;

public interface CourseService {

    CourseResponse findById(Long id);
    CourseResponse save(Course course);
    void deleteById(Long id);
    List<CourseResponse> findCoursesByInstructorId(Long instructorId);
}
