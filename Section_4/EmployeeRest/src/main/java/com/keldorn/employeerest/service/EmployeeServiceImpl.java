package com.keldorn.employeerest.service;

import com.keldorn.employeerest.dto.EmployeeDto;
import com.keldorn.employeerest.dto.EmployeeRequest;
import com.keldorn.employeerest.entity.Employee;
import com.keldorn.employeerest.exception.EmployeeNotFoundException;
import com.keldorn.employeerest.mapper.EmployeeMapper;
import com.keldorn.employeerest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    private Employee findEntityById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee id not found: " + id));
    }

    @Override
    public EmployeeDto findById(int id) {
        return mapper.toDto(findEntityById(id));
    }

    @Override
    public EmployeeDto create(EmployeeRequest request) {
        return mapper.toDto(repository.save(mapper.toEntity(request)));
    }

    @Override
    public EmployeeDto update(int id, EmployeeRequest request) {
        Employee employee = findEntityById(id);
        employee.setEmail(request.getEmail());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());

        return mapper.toDto(repository.save(employee));
    }

    @Override
    public EmployeeDto patch(int id, EmployeeRequest request) {
        Employee employee = findEntityById(id);
        if (request.getEmail() != null) employee.setEmail(request.getEmail());
        if (request.getFirstName() != null) employee.setFirstName(request.getFirstName());
        if (request.getLastName() != null) employee.setLastName(request.getLastName());

        return mapper.toDto(repository.save(employee));
    }

    @Override
    public void deleteById(int id) {
        findEntityById(id);
        repository.deleteById(id);
    }
}
