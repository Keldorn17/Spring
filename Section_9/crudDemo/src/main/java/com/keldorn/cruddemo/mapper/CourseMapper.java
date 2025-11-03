package com.keldorn.cruddemo.mapper;

import com.keldorn.cruddemo.domain.dto.CourseDto;
import com.keldorn.cruddemo.domain.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toDto(Course course);
}
