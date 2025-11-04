package com.keldorn.cruddemo.repository;

import com.keldorn.cruddemo.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.instructor.id = :id")
    List<Course> findCoursesByInstructorId(Long id);
}
