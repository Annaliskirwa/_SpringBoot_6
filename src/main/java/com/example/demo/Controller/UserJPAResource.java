package com.example.demo.Controller;

import com.example.demo.Entities.User;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAResource {
    @Autowired
    private UserDAOService userDAOService;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveOneUser(@PathVariable int id){
        User user = userDAOService.findOne(id);
        if(user == null)throw new UserNotFoundException("id-"+ id);
        EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkToUsers.withRel("all-users"));
        return  model;
    }
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDAOService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDAOService.deleteById(id);
        if(user == null)throw new UserNotFoundException("id-"+ id);

    }
}


