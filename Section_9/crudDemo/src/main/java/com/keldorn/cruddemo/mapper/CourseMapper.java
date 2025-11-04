package com.keldorn.cruddemo.mapper;

import com.keldorn.cruddemo.domain.dto.CourseResponse;
import com.keldorn.cruddemo.domain.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseResponse toDto(Course course);
}
