package com.keldorn.cruddemo.domain.dto;

public record InstructorDto(Long id, String firstName, String lastName, String email,
                            InstructorDetailDto instructorDetailDto) {
}
