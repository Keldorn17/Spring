package com.keldorn.cruddemo.domain.dto.course;

import com.keldorn.cruddemo.domain.dto.review.ReviewResponse;

import java.util.List;

public record CourseWithReviewsResponse(Long id, String title, List<ReviewResponse> reviewResponses) {
}
