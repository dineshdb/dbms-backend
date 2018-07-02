package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.LoginInfo;
import com.sankalpa.ictc_events.model.User;
import com.sankalpa.ictc_events.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public @ResponseBody LoginInfo login(@RequestBody User user){

        User loggedInUser = userService.login(user);

        LoginInfo info = new LoginInfo(Long.getLong("-1"), user.getUserName(), user.getUserPassword(), "", 404);

        if (loggedInUser != null) {

            // 202 responseCode is a success
            info.setResponseCode(202);
            info.setUserId(loggedInUser.getUserId());
            info.setUserRole(loggedInUser.getDiscriminatorValue());
        }

        return info;
    }

    @GetMapping("/users")
    public @ResponseBody List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public @ResponseBody User getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User newUser){
        userService.addUser(newUser);
    }

    @PutMapping("/users/{userId}")
    public void updateUser(@RequestBody User updatedUser,
                           @PathVariable Long userId){
        userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}