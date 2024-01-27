package com.tweteroo.api.controllers;

import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;


import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController{
    final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO userDTO){
        Optional<UserModel> user = userService.createUser(userDTO);

        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("UserName already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}