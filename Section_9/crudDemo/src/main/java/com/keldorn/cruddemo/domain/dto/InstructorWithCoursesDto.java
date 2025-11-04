package com.keldorn.cruddemo.domain.dto;

import java.util.List;

public record InstructorWithCoursesDto(Long id, String firstName, String lastName, String email,
                                       InstructorDetailResponse instructorDetailResponse, List<CourseResponse> courseResponse) {
}
