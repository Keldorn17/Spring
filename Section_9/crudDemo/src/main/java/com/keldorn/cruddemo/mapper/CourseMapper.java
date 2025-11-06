package com.keldorn.cruddemo.mapper;

import com.keldorn.cruddemo.domain.dto.course.CourseResponse;
import com.keldorn.cruddemo.domain.dto.course.CourseWithReviewsResponse;
import com.keldorn.cruddemo.domain.dto.course.CourseWithStudentsResponse;
import com.keldorn.cruddemo.domain.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseResponse toDto(Course course);

    @Mapping(target = "reviewResponses", source = "reviews")
    CourseWithReviewsResponse toCourseWithReviews(Course course);

    @Mapping(target = "studentResponses", source = "students")
    CourseWithStudentsResponse toCourseWithStudents(Course course);
}
