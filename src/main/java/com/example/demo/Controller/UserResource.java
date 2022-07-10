package com.example.demo.Controller;

import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Service.UserDAOService;
import com.example.demo.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = userDAOService.findOne(id);
        if(user == null)throw new UserNotFoundException("id-"+ id);
        return  user;
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = userDAOService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDAOService.deleteById(id);
        if(user == null)throw new UserNotFoundException("id-"+ id);

    }
}
