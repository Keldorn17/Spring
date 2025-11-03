package com.keldorn.cruddemo.mapper;

import com.keldorn.cruddemo.domain.dto.InstructorDto;
import com.keldorn.cruddemo.domain.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    @Mapping(target = "instructorDetailDto", source = "instructorDetail")
    @Mapping(target = "courseDto", source = "courses")
    InstructorDto toDto(Instructor instructor);
}
