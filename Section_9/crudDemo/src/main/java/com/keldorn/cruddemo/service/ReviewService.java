package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.review.ReviewResponse;

public interface ReviewService {

    ReviewResponse findById(Long id);
    void deleteById(Long id);
}
