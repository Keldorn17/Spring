package com.keldorn.cruddemo.domain.dto.instructor;

import com.keldorn.cruddemo.domain.dto.course.CourseResponse;

import java.util.List;

public record InstructorWithCoursesDto(Long id, String firstName, String lastName, String email,
                                       InstructorDetailResponse instructorDetailResponse, List<CourseResponse> courseResponse) {
}
