package com.keldorn.cruddemo.repository;

import com.keldorn.cruddemo.domain.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {
}
