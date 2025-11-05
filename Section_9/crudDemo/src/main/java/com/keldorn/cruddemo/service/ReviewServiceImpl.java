package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.review.ReviewResponse;
import com.keldorn.cruddemo.domain.entity.Review;
import com.keldorn.cruddemo.exception.ReviewNotFoundException;
import com.keldorn.cruddemo.mapper.ReviewMapper;
import com.keldorn.cruddemo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper mapper;
    private final ReviewRepository repository;

    @Autowired
    public ReviewServiceImpl(ReviewMapper mapper, ReviewRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    private Review findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found by id: " + id));
    }

    @Override
    public ReviewResponse findById(Long id) {
        return mapper.toDto(findByIdOrThrow(id));
    }

    @Override
    public void deleteById(Long id) {
        findByIdOrThrow(id);
        repository.deleteById(id);
    }
}
