package com.keldorn.employeerest.dao;

import com.keldorn.employeerest.entity.Employee;

import java.util.List;

@Deprecated
public interface EmployeeDao {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
