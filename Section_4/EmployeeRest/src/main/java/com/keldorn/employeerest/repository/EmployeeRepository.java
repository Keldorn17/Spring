package com.keldorn.employeerest.repository;

import com.keldorn.employeerest.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();
}
