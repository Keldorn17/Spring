package com.keldorn.aspectorientedprogramming;

import com.keldorn.aspectorientedprogramming.dao.AccountDao;
import com.keldorn.aspectorientedprogramming.dao.MembershipDao;
import com.keldorn.aspectorientedprogramming.dto.Account;
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
    public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao) {

        return runner -> {
//            demoBeforeAdvice(accountDao, membershipDao);
            demoAfterReturningAdvice(accountDao);
        };
    }

    private void demoAfterReturningAdvice(AccountDao accountDao) {

        System.out.println("Accounts: " + accountDao.findAccounts());
    }

    private void demoBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {

        accountDao.addAccount(new Account("Madhu", "Platinum"), true);
        accountDao.getName();
        accountDao.doWork();
        membershipDao.addAccount();
    }
}
