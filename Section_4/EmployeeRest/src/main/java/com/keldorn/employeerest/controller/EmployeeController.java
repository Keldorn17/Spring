package com.keldorn.employeerest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.keldorn.employeerest.entity.Employee;
import com.keldorn.employeerest.exception.EmployeeIdNotAllowedException;
import com.keldorn.employeerest.exception.EmployeeNotFoundException;
import com.keldorn.employeerest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final ObjectMapper objectMapper;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return getEmployeeOrThrow(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        getEmployeeOrThrow(id);

        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/employees")
    public Employee putEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload) {
        Employee employee = getEmployeeOrThrow(id);

        if (patchPayload.containsKey("id")) {
            throw new EmployeeIdNotAllowedException("Employee id not allowed in request body: " + id);
        }

        Employee patchedEmployee = apply(patchPayload, employee);

        return employeeService.save(patchedEmployee);
    }

    private Employee apply(Map<String, Object> patchPayload, Employee employee) {
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        employeeNode.setAll(patchNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    private Employee getEmployeeOrThrow(int id) {
        return Optional.ofNullable(employeeService.findById(id))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee id not found: " + id));
    }
}
