package com.keldorn.cruddemo;

import com.keldorn.cruddemo.domain.dto.InstructorRequest;
import com.keldorn.cruddemo.domain.entity.Course;
import com.keldorn.cruddemo.domain.entity.Instructor;
import com.keldorn.cruddemo.domain.entity.InstructorDetail;
import com.keldorn.cruddemo.service.CourseService;
import com.keldorn.cruddemo.service.InstructorDetailService;
import com.keldorn.cruddemo.service.InstructorService;
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
                                               CourseService courseService) {

        return runner -> {
//            createInstructor(instructorService);
            findInstructor(instructorService, 3L);
            findInstructorDetail(instructorDetailService, 3L);
            findCourseById(courseService, 10L);
            findCourseByInstructorId(courseService, 3L);
            updateInstructor(instructorService, new InstructorRequest("asd", "asd", "asd"), 7L);
//            deleteInstructor(instructorService, 4L);
        };
    }

    private void updateInstructor(InstructorService instructorService, InstructorRequest instructorRequest, Long id) {
        System.out.println(instructorService.update(instructorRequest, id));
    }

    private void deleteInstructor(InstructorService service, Long id) {

        System.out.println("Deleting instructor by id: " + id);
        service.deleteById(id);
        System.out.println("Deleted successfully");
    }

    private void findInstructor(InstructorService service, Long id) {

        System.out.println("Finding instructor id: " + id);
        System.out.println("Eager: " + service.findByIdWithCourses(id));
        System.out.println("Lazy: " + service.findById(id));
    }

    private void findInstructorDetail(InstructorDetailService service, Long id) {

        System.out.println("Finding instructorDetail id: " + id);
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
        System.out.println("Saving instructor: " +service.save(instructor));
    }

    private void findCourseById(CourseService service, Long id) {

        System.out.println("Finding Course id: " + id);
        System.out.println(service.findById(id));
    }

    private void findCourseByInstructorId(CourseService service, Long instructorId) {
        System.out.printf("Courses (Instructor id: %d): %s%n", instructorId, service.findCoursesByInstructorId(instructorId));
    }
}
