package com.keldorn.cruddemo.mapper;

import com.keldorn.cruddemo.domain.dto.student.StudentRequest;
import com.keldorn.cruddemo.domain.dto.student.StudentResponse;
import com.keldorn.cruddemo.domain.dto.student.StudentWithCourseResponse;
import com.keldorn.cruddemo.domain.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponse toResponse(Student student);

    @Mapping(target = "courseResponses", source = "courses")
    StudentWithCourseResponse toStudentWithCourses(Student student);

    Student toEntity(StudentRequest request);
}
