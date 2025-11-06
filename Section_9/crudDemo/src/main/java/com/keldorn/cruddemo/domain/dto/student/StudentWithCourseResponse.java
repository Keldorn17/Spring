package com.keldorn.cruddemo.domain.dto.student;

import com.keldorn.cruddemo.domain.dto.course.CourseResponse;

import java.util.List;

public record StudentWithCourseResponse(Long id, String firstName, String lastName, String email, List<CourseResponse> courseResponses) {
}
