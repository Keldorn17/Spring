package com.keldorn.cruddemo.domain.dto.instructor;

public record InstructorResponse(Long id, String firstName, String lastName, String email,
                                 InstructorDetailResponse instructorDetailResponse) {
}
