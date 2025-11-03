package com.keldorn.cruddemo.mapper;

import com.keldorn.cruddemo.domain.dto.InstructorDetailDto;
import com.keldorn.cruddemo.domain.entity.InstructorDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorDetailMapping {

    InstructorDetailDto toDto(InstructorDetail instructorDetail);
}
