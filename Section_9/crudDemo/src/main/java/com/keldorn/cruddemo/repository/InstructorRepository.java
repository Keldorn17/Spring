package com.keldorn.cruddemo.repository;

import com.keldorn.cruddemo.domain.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
