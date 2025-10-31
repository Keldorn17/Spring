package com.keldorn.demosecurity.service;

import com.keldorn.demosecurity.entity.User;
import com.keldorn.demosecurity.entity.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);
    void save(WebUser webUser);
}
