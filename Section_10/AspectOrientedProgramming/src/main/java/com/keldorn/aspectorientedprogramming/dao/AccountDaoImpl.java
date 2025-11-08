package com.keldorn.aspectorientedprogramming.dao;

import com.keldorn.aspectorientedprogramming.dto.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {


    @Override
    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {

        System.out.println(getClass().getSimpleName() + ": doWork()");
        return true;
    }
}
