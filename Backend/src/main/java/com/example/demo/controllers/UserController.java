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

    //Method that posts new users in the db
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<User>(userservice.saveUser(user), HttpStatus.CREATED);
    }

    //Method that gets all the users that are in db.
    @GetMapping
    public List<User> fetchUsers() {
        return userepo.findAll();
    }

    //Search of a single user by id.
    @RequestMapping("/byid/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userid){
        return new ResponseEntity<User>(userservice.findUserById(userid),HttpStatus.OK);
    }

    //Search of users by firstname like the "firstname" value that we give.
    @RequestMapping("/byname/{firstName}")
    public List<User> findByName(@PathVariable("firstName") String firstName){
        return userservice.getUsersWithName(firstName);
    }

    //Update(put) method of the user with id= {id}.
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return new ResponseEntity<User>(userservice.updateUser(user,id),HttpStatus.OK);
    }

    //Delete of the user with the given id.
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){

        userservice.deleteUser(id);

        return new ResponseEntity<String>("User deleted successfully!",HttpStatus.OK);
    }

}
