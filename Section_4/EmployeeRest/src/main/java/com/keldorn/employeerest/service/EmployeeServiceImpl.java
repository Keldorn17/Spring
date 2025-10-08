package com.keldorn.employeerest.service;

import com.keldorn.employeerest.dto.EmployeeRequest;
import com.keldorn.employeerest.entity.Employee;
import com.keldorn.employeerest.exception.EmployeeNotFoundException;
import com.keldorn.employeerest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee id not found: " + id));
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee save(int id, EmployeeRequest request) {
        Employee employee = findById(id);
        employee.setEmail(request.getEmail());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        return employee;
    }

    @Override
    public void deleteById(int id) {
        findById(id);
        repository.deleteById(id);
    }
}
