package com.keldorn.employeerest.mapper;

import com.keldorn.employeerest.dto.EmployeeDto;
import com.keldorn.employeerest.dto.EmployeeRequest;
import com.keldorn.employeerest.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);
    Employee toEntity(EmployeeRequest request);
}
