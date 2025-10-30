package com.keldorn.demosecurity.service;

import com.keldorn.demosecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);
}
