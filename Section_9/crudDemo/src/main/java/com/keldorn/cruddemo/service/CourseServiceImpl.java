package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.CourseResponse;
import com.keldorn.cruddemo.domain.entity.Course;
import com.keldorn.cruddemo.exception.CourseNotFoundException;
import com.keldorn.cruddemo.mapper.CourseMapper;
import com.keldorn.cruddemo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseMapper mapper;
    private final CourseRepository repository;

    @Autowired
    public CourseServiceImpl(CourseMapper mapper, CourseRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    private Course findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found by id: " + id));
    }

    @Override
    public CourseResponse findById(Long id) {
        return mapper.toDto(findByIdOrThrow(id));
    }

    @Override
    public CourseResponse save(Course course) {
        return mapper.toDto(repository.save(course));
    }

    @Override
    public void deleteById(Long id) {
        findByIdOrThrow(id);
        repository.deleteById(id);
    }

    @Override
    public List<CourseResponse> findCoursesByInstructorId(Long instructorId) {
        var courses = repository.findCoursesByInstructorId(instructorId);
        if (courses.isEmpty()) {
            throw new CourseNotFoundException("No course found with instructor id: " + instructorId);
        }
        return courses.stream()
                .map(mapper::toDto)
                .toList();
    }
}
