package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.CourseDto;
import com.keldorn.cruddemo.domain.entity.Course;

public interface CourseService {

    CourseDto findById(Long id);
    CourseDto save(Course course);
    void deleteById(Long id);
}
