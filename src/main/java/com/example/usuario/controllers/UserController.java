package com.example.usuario.controllers;

import com.example.usuario.exceptions.NotFoundException;
import com.example.usuario.models.User;
import com.example.usuario.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public User addUser(@Valid @RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById (@PathVariable (value="id") long userId){
        return userService.findById(userId);
    }

}