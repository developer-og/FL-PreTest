package com.crud.controller;

import com.crud.model.User;

import java.util.List;

import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/search")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUserByUserId(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping(value = "/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

}
