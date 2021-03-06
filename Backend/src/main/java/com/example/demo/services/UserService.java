package com.example.demo.services;


import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository userepo;

    @Autowired
    public UserService(UserRepository userepo) {
        super();
        this.userepo= userepo;
    }


    public User saveUser(User user){
        return userepo.save(user);
    }

    public User findUserById(Long id){
        return userepo.findById(id).orElseThrow(()->new NotFoundException("User","Id",id));
    }

    public User updateUser(User user, Long id){

        User existingUser = userepo.findById(id).orElseThrow(
        ()-> new NotFoundException("User","id",id));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        userepo.save(existingUser);

        return existingUser;
    }

    public void deleteUser(Long id){

        User existingUser = userepo.findById(id).orElseThrow(
                ()-> new NotFoundException("User","id",id));

        userepo.deleteById(id);
    }

    public List<User> getUsersWithName(String firstName){
        return userepo.findbyName(firstName);
    }
}
