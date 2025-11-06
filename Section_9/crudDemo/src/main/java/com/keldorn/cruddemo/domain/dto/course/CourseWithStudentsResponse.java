package com.keldorn.cruddemo.domain.dto.course;

import com.keldorn.cruddemo.domain.dto.student.StudentResponse;

import java.util.List;

public record CourseWithStudentsResponse(Long id, String title, List<StudentResponse> studentResponses) {
}
