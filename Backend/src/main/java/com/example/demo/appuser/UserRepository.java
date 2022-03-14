package com.example.demo.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id= ?1")
    User findByID(Long id);

    @Query("SELECT u FROM User u WHERE u.firstname= ?1")
    User findbyName(String firstName);
}
