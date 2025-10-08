package com.keldorn.employeerest.controller;

import com.keldorn.employeerest.dto.EmployeeDto;
import com.keldorn.employeerest.dto.EmployeeRequest;
import com.keldorn.employeerest.entity.Employee;
import com.keldorn.employeerest.mapper.EmployeeMapper;
import com.keldorn.employeerest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService service;
    private final EmployeeMapper mapper;

    @Autowired
    public EmployeeController(EmployeeService service, EmployeeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees() {
        return service.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id) {
        return mapper.toDto(service.findById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeRequest request) {
        EmployeeDto employeeDto = mapper.toDto(service.save(mapper.toEntity(request)));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDto);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/employees/{id}")
    public Employee putEmployee(@PathVariable int id, @RequestBody EmployeeRequest employeeRequest) {
        return service.save(id, employeeRequest);
    }

    @PatchMapping("/employees/{id}")
    public EmployeeDto patchEmployee(@PathVariable int id, @RequestBody EmployeeRequest request) {
        Employee employee = service.findById(id);
        if (request.getEmail() != null) employee.setEmail(request.getEmail());
        if (request.getFirstName() != null) employee.setFirstName(request.getFirstName());
        if (request.getLastName() != null) employee.setLastName(request.getLastName());

        return mapper.toDto(service.save(employee));
    }
}
