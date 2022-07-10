package Controller;

import com.example.demo.Service.UserDAOService;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDAOService userDAOService;

    public List<User> retrieveAllUsers(){
        return userDAOService.findAll();
    }
}
