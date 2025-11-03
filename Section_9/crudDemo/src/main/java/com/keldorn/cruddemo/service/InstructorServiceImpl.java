package com.keldorn.cruddemo.service;

import com.keldorn.cruddemo.domain.dto.InstructorDto;
import com.keldorn.cruddemo.domain.entity.Instructor;
import com.keldorn.cruddemo.exception.InstructorNotFoundException;
import com.keldorn.cruddemo.mapper.InstructorMapper;
import com.keldorn.cruddemo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorMapper mapper;
    private final InstructorRepository repository;

    @Autowired
    public InstructorServiceImpl(InstructorMapper mapper, InstructorRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    private Instructor findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found by id: " + id));
    }

    @Override
    public InstructorDto findById(Long id) {
        return mapper.toDto(findByIdOrThrow(id));
    }

    @Override
    public InstructorDto save(Instructor instructor) {
        return mapper.toDto(repository.save(instructor));
    }

    @Override
    public void deleteById(Long id) {
        findByIdOrThrow(id);
        repository.deleteById(id);
    }
}
