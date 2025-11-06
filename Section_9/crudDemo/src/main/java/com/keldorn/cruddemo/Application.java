package com.keldorn.cruddemo;

import com.keldorn.cruddemo.domain.dto.course.CourseRequest;
import com.keldorn.cruddemo.domain.dto.instructor.InstructorRequest;
import com.keldorn.cruddemo.domain.dto.student.StudentRequest;
import com.keldorn.cruddemo.domain.entity.*;
import com.keldorn.cruddemo.service.CourseService;
import com.keldorn.cruddemo.service.InstructorDetailService;
import com.keldorn.cruddemo.service.InstructorService;
import com.keldorn.cruddemo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorService instructorService,
                                               InstructorDetailService instructorDetailService,
                                               CourseService courseService,
                                               StudentService studentService) {

        return runner -> {
//            createCourseAndStudents(courseService);
//            addMoreCoursesForStudent(courseService, studentService, 1L);
            findCourseAndStudents(courseService, 10L);
            findStudentAndCourses(studentService, 1L);
        };
    }

    private void addMoreCoursesForStudent(CourseService service, StudentService studentService, Long id) {

        Course course = new Course("Rubik's Cube - How to Speed Cube");
        var courseResponse = service.save(course);

        var student = studentService.findById(id);
        service.addStudent(new StudentRequest(student.firstName(), student.lastName(), student.email()),
                id, courseResponse.id());
    }

    private void findStudentAndCourses(StudentService service, Long studentId) {

        System.out.println(service.findWithCourseById(studentId));
    }

    private void findCourseAndStudents(CourseService service, Long courseId) {

        System.out.println(service.findWithStudentById(courseId));
    }

    private void createCourseAndStudents(CourseService service) {

        Course course = new Course("Pacman = How To Score One Million Points");

        Student student1 = new Student("John", "Doe", "john@mail.com");
        Student student2 = new Student("Mary", "Public", "mary@mail.com");

        course.addStudent(student1);
        course.addStudent(student2);

        service.save(course);
    }

    private void updateInstructor(InstructorService service, InstructorRequest request, Long id) {
        System.out.println(service.update(request, id));
    }

    private void updateCourse(CourseService service, CourseRequest request, Long id) {
        System.out.println(service.update(request, id));
    }

    private void deleteInstructor(InstructorService service, Long id) {

        System.out.println("Deleting instructor by id: " + id);
        service.deleteById(id);
        System.out.println("Deleted successfully");
    }

    private void findInstructor(InstructorService service, Long id) {

        System.out.println("Eager: " + service.findByIdWithCourses(id));
        System.out.println("Lazy: " + service.findById(id));
    }

    private void findInstructorDetail(InstructorDetailService service, Long id) {

        System.out.println(service.findById(id));
    }

    private void createInstructor(InstructorService service) {

        Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

        InstructorDetail instructorDetail =
                new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code");

        Course courseJava = new Course("Java");
        Course coursePython = new Course("Python");

        instructor.setInstructorDetail(instructorDetail);
        instructor.add(courseJava);
        instructor.add(coursePython);
        System.out.println("Saving instructor: " + service.save(instructor));
    }

    private void findCourseById(CourseService service, Long id) {

        System.out.println(service.findById(id));
    }

    private void findCourseWithReviewsById(CourseService service, Long id) {

        System.out.println(service.findWithReviewById(id));
    }

    private void findCourseByInstructorId(CourseService service, Long instructorId) {

        System.out.printf("Courses (Instructor id: %d): %s%n", instructorId, service.findCoursesByInstructorId(instructorId));
    }

    private void createCourseAndReviews(CourseService service) {
        Course course = new Course("Pacman");

        course.addReview(new Review("Great course"));
        course.addReview(new Review("Cool course"));
        course.addReview(new Review("Worst course"));

        service.save(course);
    }
}
