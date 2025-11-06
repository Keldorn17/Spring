package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.course.CourseRequest;
import com.keldorn.cruddemo.domain.dto.course.CourseResponse;
import com.keldorn.cruddemo.domain.dto.course.CourseWithReviewsResponse;
import com.keldorn.cruddemo.domain.dto.course.CourseWithStudentsResponse;
import com.keldorn.cruddemo.domain.dto.review.ReviewRequest;
import com.keldorn.cruddemo.domain.dto.student.StudentRequest;
import com.keldorn.cruddemo.domain.entity.Course;
import com.keldorn.cruddemo.exception.CourseNotFoundException;
import com.keldorn.cruddemo.mapper.CourseMapper;
import com.keldorn.cruddemo.mapper.ReviewMapper;
import com.keldorn.cruddemo.mapper.StudentMapper;
import com.keldorn.cruddemo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseMapper mapper;
    private final ReviewMapper reviewMapper;
    private final StudentMapper studentMapper;
    private final CourseRepository repository;

    @Autowired
    public CourseServiceImpl(CourseMapper mapper, ReviewMapper reviewMapper, StudentMapper studentMapper, CourseRepository repository) {
        this.mapper = mapper;
        this.reviewMapper = reviewMapper;
        this.studentMapper = studentMapper;
        this.repository = repository;
    }

    private Supplier<CourseNotFoundException> notFound(Long id) {
        return () -> new CourseNotFoundException("Course not found by id: " + id);
    }

    private Course findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(notFound(id));
    }

    private Course findWithReviewByIdOrThrow(Long id) {
        return repository.findWithReviewsById(id)
                .orElseThrow(notFound(id));
    }

    private Course findWithStudentByIdOrThrow(Long id) {
        return repository.findWithStudentById(id)
                .orElseThrow(notFound(id));
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

    @Override
    public CourseWithReviewsResponse findWithReviewById(Long id) {
        return mapper.toCourseWithReviews(findWithReviewByIdOrThrow(id));
    }

    @Override
    public CourseWithStudentsResponse findWithStudentById(Long id) {
        return mapper.toCourseWithStudents(findWithStudentByIdOrThrow(id));
    }

    @Override
    public void addReviewToCourse(ReviewRequest request, Long courseId) {
        var course = findWithReviewByIdOrThrow(courseId);
        course.addReview(reviewMapper.toEntity(request));
        repository.save(course);
    }

    @Override
    public void addStudent(StudentRequest request, Long studentId, Long courseId) {
        var course = findWithStudentByIdOrThrow(courseId);
        var student = studentMapper.toEntity(request);
        student.setId(studentId);
        course.addStudent(student);
        repository.save(course);
    }

    @Override
    public CourseResponse update(CourseRequest request, Long id) {
        var course = findByIdOrThrow(id);
        course.setTitle(request.title());

        return mapper.toDto(repository.save(course));
    }
}
