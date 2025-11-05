package com.keldorn.cruddemo.repository;

import com.keldorn.cruddemo.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.instructor.id = :id")
    List<Course> findCoursesByInstructorId(Long id);

    @Query("SELECT DISTINCT c FROM Course c LEFT JOIN FETCH c.reviews WHERE c.id = :id")
    Optional<Course> findWithReviewsById(Long id);
}
