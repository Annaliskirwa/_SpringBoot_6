package com.example.demo.Service;

import com.example.demo.Entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;
    static {
        users.add(new User(1, "Annalis", new Date()));
        users.add(new User(2, "Anna", new Date()));
        users.add(new User(3, "Ann", new Date()));
    }
    //find all users
    public List<User> findAll(){
        return users;
    }
    //save user
    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }
    //find one user
    public User findOne(int id){
        for(User user: users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
