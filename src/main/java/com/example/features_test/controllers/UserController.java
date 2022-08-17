package com.example.features_test.controllers;

import com.example.features_test.db.entities.User;
import com.example.features_test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserInfo(@RequestBody User user) {
        userService.updateUserInfo(user);
    }

}
