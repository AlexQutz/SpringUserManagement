package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    //The JPA repository is the interface that contains methods that make the db queries like findAll(),findById(),etc.
    @Query(value="SELECT u FROM User u WHERE u.firstName LIKE %?1%")
    public List<User> findbyName(String firstName);
}
