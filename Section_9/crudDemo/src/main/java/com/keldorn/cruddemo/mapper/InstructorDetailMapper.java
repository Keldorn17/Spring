package com.keldorn.cruddemo.mapper;

import com.keldorn.cruddemo.domain.dto.InstructorDetailResponse;
import com.keldorn.cruddemo.domain.entity.InstructorDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorDetailMapper {

    InstructorDetailResponse toDto(InstructorDetail instructorDetail);
}
