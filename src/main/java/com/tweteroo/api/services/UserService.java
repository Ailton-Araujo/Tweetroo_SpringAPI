package com.tweteroo.api.services;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService{
    final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<UserModel> createUser(UserDTO userDTO){
        if(userRepository.existsByUserName(userDTO.getUserName())){
            return Optional.empty();
        }
        User newUser = new User(userDTO);
        return Optional.of(userRepository.save((newUser)));
    }
}