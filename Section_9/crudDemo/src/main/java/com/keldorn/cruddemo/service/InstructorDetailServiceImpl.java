package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.instructor.InstructorDetailResponse;
import com.keldorn.cruddemo.domain.entity.InstructorDetail;
import com.keldorn.cruddemo.exception.InstructorDetailNotFoundException;
import com.keldorn.cruddemo.mapper.InstructorDetailMapper;
import com.keldorn.cruddemo.repository.InstructorDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

    private final InstructorDetailMapper mapper;
    private final InstructorDetailRepository repository;

    @Autowired
    public InstructorDetailServiceImpl(InstructorDetailMapper mapper, InstructorDetailRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    private InstructorDetail findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new InstructorDetailNotFoundException("Instructor Detail not found by id: " + id));
    }

    @Override
    public InstructorDetailResponse findById(Long id) {
        return mapper.toDto(findByIdOrThrow(id));
    }

    @Override
    public InstructorDetailResponse save(InstructorDetail instructorDetail) {
        return mapper.toDto(repository.save(instructorDetail));
    }

    @Override
    public void deleteById(Long id) {
        findByIdOrThrow(id);
        repository.deleteById(id);
    }
}
