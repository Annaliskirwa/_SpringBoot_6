package com.example.demo.Controller;

import com.example.demo.Service.UserDAOService;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDAOService userDAOService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDAOService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveOneUser(@PathVariable int id){
        return userDAOService.findOne(id);
    }
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        User savedUser = userDAOService.save(user);
    }
}
