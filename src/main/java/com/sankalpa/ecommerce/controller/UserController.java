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

    @GetMapping("/add")
	public @ResponseBody String
    getUser(@RequestBody Long user) {
		return "DOne";
	}

}