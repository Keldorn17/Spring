package com.keldorn.employeemvc.repository;

import com.keldorn.employeemvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
