package com.keldorn.cruddemo.domain.dto;

import java.util.List;

public record InstructorDto(Long id, String firstName, String lastName, String email,
                            InstructorDetailDto instructorDetailDto, List<CourseDto> courseDto) {
}
