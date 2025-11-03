package com.keldorn.cruddemo;

import com.keldorn.cruddemo.domain.entity.Instructor;
import com.keldorn.cruddemo.domain.entity.InstructorDetail;
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
                                               InstructorDetailService instructorDetailService) {

        return runner -> {
            findInstructor(instructorService, 1L);
            findInstructorDetail(instructorDetailService, 1L);
//            createInstructor(instructorService);
//            deleteInstructor(instructorService, 4L);
        };
    }

    private void deleteInstructor(InstructorService service, Long id) {

        System.out.println("Deleting instructor by id: " + id);
        service.deleteById(id);
        System.out.println("Deleted successfully");
    }

    private void findInstructor(InstructorService service, Long id) {

        System.out.println("Finding instructor id: " + id);
        System.out.println(service.findById(id));
    }

    private void findInstructorDetail(InstructorDetailService service, Long id) {

        System.out.println("Finding instructorDetail id: " + id);
        System.out.println(service.findById(id));
    }

    private void createInstructor(InstructorService service) {

        Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

        InstructorDetail instructorDetail =
                new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code");

        instructor.setInstructorDetail(instructorDetail);
        System.out.println("Saving instructor: " +service.save(instructor));
    }
}
