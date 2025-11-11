package com.keldorn.aspectorientedprogramming.dao;

import com.keldorn.aspectorientedprogramming.dto.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAccounts();

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    String getName();

    String getServiceCode();

    void setName(String name);

    void setServiceCode(String serviceCode);

}
