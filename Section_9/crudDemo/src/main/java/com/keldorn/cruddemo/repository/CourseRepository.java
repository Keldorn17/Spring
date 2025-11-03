package com.keldorn.cruddemo.repository;

import com.keldorn.cruddemo.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
