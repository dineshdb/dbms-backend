package com.sankalpa.ecommerce.controller;

import com.sankalpa.ecommerce.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/users")
public class UserController{
/*
	@GetMapping("/{user}")
	public Mono<User> getUser(@PathVariable Long user) {
		neturn null;
	}
	*/
}