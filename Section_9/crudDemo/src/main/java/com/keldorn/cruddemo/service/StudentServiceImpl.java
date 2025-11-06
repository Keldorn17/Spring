package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.student.StudentResponse;
import com.keldorn.cruddemo.domain.dto.student.StudentWithCourseResponse;
import com.keldorn.cruddemo.domain.entity.Student;
import com.keldorn.cruddemo.exception.StudentNotFoundException;
import com.keldorn.cruddemo.mapper.StudentMapper;
import com.keldorn.cruddemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper mapper;
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentMapper mapper, StudentRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    private Student findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found by id: " + id));
    }

    private Student findWithCourseByIdOrThrow(Long id) {
        return repository.findWithCourseById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found by id: " + id));
    }

    @Override
    public StudentWithCourseResponse findWithCourseById(Long id) {
        return mapper.toStudentWithCourses(findWithCourseByIdOrThrow(id));
    }

    @Override
    public StudentResponse findById(Long id) {
        return mapper.toResponse(findByIdOrThrow(id));
    }

    @Override
    public StudentResponse save(Student student) {
        return mapper.toResponse(repository.save(student));
    }

    @Override
    public void deleteById(Long id) {
        Student student = findWithCourseByIdOrThrow(id);
        student.getCourses().forEach(c -> c.getStudents().remove(student));
        repository.delete(student);
    }
}
