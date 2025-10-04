package com.keldorn.employeerest.dao;

import com.keldorn.employeerest.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
}
