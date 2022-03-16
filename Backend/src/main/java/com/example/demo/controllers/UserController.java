package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userepo;

    @Autowired
    private UserService userservice;

    public UserController(UserService userservice){
        super();
        this.userservice = userservice;
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<User>(userservice.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> fetchUsers() {
        return userepo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userid){
        return new ResponseEntity<User>(userservice.findUserById(userid),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return new ResponseEntity<User>(userservice.updateUser(user,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){

        userservice.deleteUser(id);

        return new ResponseEntity<String>("User deleted successfully!",HttpStatus.OK);
    }

}
