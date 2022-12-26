package com.sharan.controller;

import com.sharan.model.User;
import com.sharan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User newUser) {
        userService.createNewUser(newUser);
    }
}
