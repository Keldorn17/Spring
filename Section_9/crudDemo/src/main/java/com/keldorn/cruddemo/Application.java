package com.keldorn.cruddemo;

import com.keldorn.cruddemo.dao.AppDao;
import com.keldorn.cruddemo.entity.Instructor;
import com.keldorn.cruddemo.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(AppDao appDao) {

        return runner -> {
            createInstructor(appDao);
        };
    }

    private void createInstructor(AppDao appDao) {

        Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

        InstructorDetail instructorDetail =
                new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code");

        instructor.setInstructorDetail(instructorDetail);
        System.out.println("Saving instructor: " + instructor);

        appDao.save(instructor);
    }
}
