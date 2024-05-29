package com.mmtk.manga.Controller;

import com.mmtk.manga.Model.User;
import com.mmtk.manga.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webtoonhub/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public User addUser(User user){
        return userService.addUser(user);
    }

    @GetMapping("/getuser")
    public List<User> getUser(){
        return userService.getUser();
    }

    @PostMapping("/changepassword/{id}")
    public User changePassword(@PathVariable Long id, @RequestBody String password){
        return userService.changePassword(id, password);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
