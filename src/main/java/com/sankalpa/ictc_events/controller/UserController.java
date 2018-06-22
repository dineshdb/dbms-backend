package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
	public @ResponseBody String
    getUser(@PathVariable Long userId) {

        // TODO
		return "DOne";
	}
    @PostMapping("/add")
    public @ResponseBody String
    addUser(@RequestBody Long newUser) {
        // TODO
        return "DOne";
    }

}