package com.keldorn.cruddemo.mapper;

import com.keldorn.cruddemo.domain.dto.review.ReviewRequest;
import com.keldorn.cruddemo.domain.dto.review.ReviewResponse;
import com.keldorn.cruddemo.domain.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewResponse toDto(Review review);

    Review toEntity(ReviewRequest request);
}
