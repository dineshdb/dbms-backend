package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.User;
import com.sankalpa.ictc_events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public void addUser(User newUser){
        userRepository.save(newUser);
    }

    public void updateUser(Long userId, User updatedUser){
        userRepository.save(updatedUser);
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
