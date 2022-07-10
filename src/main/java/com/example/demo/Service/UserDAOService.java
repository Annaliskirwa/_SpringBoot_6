package com.example.demo.Service;

import com.example.demo.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Annalis", new Date()));
        users.add(new User(2, "Anna", new Date()));
        users.add(new User(3, "Ann", new Date()));
    }


}
