package com.keldorn.aspectorientedprogramming;

import com.keldorn.aspectorientedprogramming.dao.AccountDao;
import com.keldorn.aspectorientedprogramming.dao.MembershipDao;
import com.keldorn.aspectorientedprogramming.service.TrafficFortuneService;
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
    public CommandLineRunner commandLineRunner(AccountDao accountDao,
                                               MembershipDao membershipDao,
                                               TrafficFortuneService service) {

        return runner -> {
            System.out.println(service.getFortune(true));
        };
    }
}
