package com.hcc.controllers;

import com.hcc.entities.User;
import com.hcc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepository;

    @GetMapping("/test-users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
