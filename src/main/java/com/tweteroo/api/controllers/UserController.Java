package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.User;
import com.tweteroo.api.services.UserService;

@RequestController
@RequestMapping("/users")
public class UserController{
    final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO userDTO){
        Optional<User> user = userService.createUser(userDTO);

        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("UserName already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user.get());
    }
}