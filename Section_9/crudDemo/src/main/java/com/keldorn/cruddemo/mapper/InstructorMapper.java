package com.keldorn.cruddemo.mapper;

import com.keldorn.cruddemo.domain.dto.instructor.InstructorResponse;
import com.keldorn.cruddemo.domain.dto.instructor.InstructorWithCoursesDto;
import com.keldorn.cruddemo.domain.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    @Mapping(target = "instructorDetailResponse", source = "instructorDetail")
    @Mapping(target = "courseResponse", source = "courses")
    InstructorWithCoursesDto toInstructorWithCoursesDto(Instructor instructor);

    @Mapping(target = "instructorDetailResponse", source = "instructorDetail")
    InstructorResponse toInstructorDto(Instructor instructor);
}
