package com.keldorn.employeerest.service;

import com.keldorn.employeerest.dto.EmployeeDto;
import com.keldorn.employeerest.dto.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> findAll();
    EmployeeDto findById(int id);
    EmployeeDto create(EmployeeRequest request);
    EmployeeDto update(int id, EmployeeRequest request);
    EmployeeDto patch(int id, EmployeeRequest request);
    void deleteById(int id);
}
