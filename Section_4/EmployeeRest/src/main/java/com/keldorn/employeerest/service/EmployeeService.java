package com.keldorn.employeerest.service;

import com.keldorn.employeerest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
