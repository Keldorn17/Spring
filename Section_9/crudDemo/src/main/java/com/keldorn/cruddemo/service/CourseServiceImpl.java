package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.CourseDto;
import com.keldorn.cruddemo.domain.entity.Course;
import com.keldorn.cruddemo.exception.CourseNotFoundException;
import com.keldorn.cruddemo.mapper.CourseMapper;
import com.keldorn.cruddemo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public CourseDto findById(Long id) {
        return mapper.toDto(findByIdOrThrow(id));
    }

    @Override
    public CourseDto save(Course course) {
        return mapper.toDto(repository.save(course));
    }

    @Override
    public void deleteById(Long id) {
        findByIdOrThrow(id);
        repository.deleteById(id);
    }
}
