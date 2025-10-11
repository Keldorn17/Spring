package com.keldorn.employeerest.controller;

import com.keldorn.employeerest.dto.EmployeeDto;
import com.keldorn.employeerest.dto.EmployeeRequest;
import com.keldorn.employeerest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeRequest request) {
        var created = service.create(request);
        return ResponseEntity.created(URI.create("/api/employees/" + created.getId())).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> putEmployee(@PathVariable int id, @RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(service.update(id, employeeRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDto> patchEmployee(@PathVariable int id, @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(service.patch(id, request));
    }
}
