package com.keldorn.aspectorientedprogramming.dao;

import com.keldorn.aspectorientedprogramming.dto.Account;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class AccountDaoImpl implements AccountDao {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {

        setName(account.getName());
        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {

        System.out.println(getClass().getSimpleName() + ": doWork()");
        return true;
    }
}
