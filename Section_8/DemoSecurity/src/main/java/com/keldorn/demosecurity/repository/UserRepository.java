package com.keldorn.demosecurity.repository;

import com.keldorn.demosecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("FROM User WHERE userName = ?1 and enabled = true")
    Optional<User> findByUserName(String userName);
}
