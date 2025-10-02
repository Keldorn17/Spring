package com.keldorn.section_4.controller;

import com.keldorn.section_4.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        return new ArrayList<>(List.of(
                new Student("Poornima", "Patel"),
                new Student("Mario", "Rossi"),
                new Student("Mary", "Smith")
        ));
    }
}
