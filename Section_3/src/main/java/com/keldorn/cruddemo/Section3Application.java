package com.keldorn.cruddemo;

import com.keldorn.cruddemo.dao.StudentDAO;
import com.keldorn.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Section3Application {

    public static void main(String[] args) {
        SpringApplication.run(Section3Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> createMultipleStudents(studentDAO);
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        System.out.println("Updating student...");
        myStudent.setFirstName("Scooby");
        studentDAO.update(myStudent);

        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        studentDAO.findByLastName("Doe").forEach(System.out::println);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        students.forEach(System.out::println);
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating a new student object...");
        Student student = new Student("Daffy", "Duck", "daffy@examle.com");

        System.out.println("Saving the student...");
        studentDAO.save(student);

        int id = student.getId();

        System.out.println("Saved student. Generated id: " + id);

        System.out.println("Retrieving student with id: " + id);
        Student myStudent = studentDAO.findById(id);

        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 student object...");
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
