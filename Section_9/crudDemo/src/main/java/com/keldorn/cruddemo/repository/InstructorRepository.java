package com.keldorn.cruddemo.repository;

import com.keldorn.cruddemo.domain.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @Query("SELECT DISTINCT i FROM Instructor i LEFT JOIN FETCH i.courses WHERE i.id = :id")
    Optional<Instructor> findWithCoursesById(Long id);
}
