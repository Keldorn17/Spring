package com.keldorn.aspectorientedprogramming.dao;

import com.keldorn.aspectorientedprogramming.dto.Account;

public interface AccountDao {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
