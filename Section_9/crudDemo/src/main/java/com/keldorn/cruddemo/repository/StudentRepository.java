package com.keldorn.cruddemo.repository;

import com.keldorn.cruddemo.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("FROM Student s JOIN FETCH s.courses WHERE s.id = :id")
    Optional<Student> findWithCourseById(Long id);
}
