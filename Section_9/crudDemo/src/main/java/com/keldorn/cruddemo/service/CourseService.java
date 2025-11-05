package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.course.CourseRequest;
import com.keldorn.cruddemo.domain.dto.course.CourseResponse;
import com.keldorn.cruddemo.domain.dto.course.CourseWithReviewsResponse;
import com.keldorn.cruddemo.domain.dto.review.ReviewRequest;
import com.keldorn.cruddemo.domain.entity.Course;

import java.util.List;

public interface CourseService {

    CourseResponse findById(Long id);
    CourseResponse save(Course course);
    void deleteById(Long id);
    List<CourseResponse> findCoursesByInstructorId(Long instructorId);
    CourseWithReviewsResponse findWithReviewById(Long id);
    void addReviewToCourse(ReviewRequest request, Long courseId);
    CourseResponse update(CourseRequest request, Long id);
}
