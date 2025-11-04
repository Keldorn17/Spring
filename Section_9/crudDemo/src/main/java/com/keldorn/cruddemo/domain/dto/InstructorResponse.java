package com.keldorn.cruddemo.domain.dto;

public record InstructorResponse(Long id, String firstName, String lastName, String email,
                                 InstructorDetailResponse instructorDetailResponse) {
}
