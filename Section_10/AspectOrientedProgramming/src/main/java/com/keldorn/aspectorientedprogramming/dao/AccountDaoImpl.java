package com.keldorn.aspectorientedprogramming.dao;

import com.keldorn.aspectorientedprogramming.dto.Account;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class AccountDaoImpl implements AccountDao {

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return List.of(
                new Account("John", "Silver"),
                new Account("Madhu", "Platinum"),
                new Account("Luca", "Gold")
        );
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Trip wire triggered.");
        }

        return findAccounts();
    }

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
