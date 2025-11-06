package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.student.StudentResponse;
import com.keldorn.cruddemo.domain.dto.student.StudentWithCourseResponse;
import com.keldorn.cruddemo.domain.entity.Student;

public interface StudentService {

    StudentWithCourseResponse findWithCourseById(Long id);
    StudentResponse findById(Long id);
    StudentResponse save(Student student);
    void deleteById(Long id);
}
