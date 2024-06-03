package org.eventorganizer.app.controller;

import org.eventorganizer.app.entity.User;
import org.eventorganizer.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println("Called Create User from Controller");
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable Long id,@RequestBody User user){
        userService.updateUser(id, user);
    }

    @GetMapping(path = "findByUserName{userName}")
    public User findByUserName(@PathVariable String userName){
        return userService.findUserByUserName(userName);
    }


}
