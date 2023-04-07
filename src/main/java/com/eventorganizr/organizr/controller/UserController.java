package com.eventorganizr.organizr.controller;

import com.eventorganizr.organizr.entity.User;
import com.eventorganizr.organizr.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping (path = "/api/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        //Has to be JSON Formatted when testing in PostMan
        userService.saveUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable Long id,@RequestBody User user){
        userService.updateUser(id, user);
    }


}
