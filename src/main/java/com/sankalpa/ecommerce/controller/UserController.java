package com.sankalpa.ecommerce.controller;

import com.sankalpa.ecommerce.UserRepository;
import com.sankalpa.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/user")
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