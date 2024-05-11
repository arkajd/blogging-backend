package com.example.bloggingbackend.controllers;

import com.example.bloggingbackend.dto.CreateUserRequestDTO;
import com.example.bloggingbackend.dto.DeleteUserRequestDTO;
import com.example.bloggingbackend.dto.UpdateUserPasswordRequestDTO;
import com.example.bloggingbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO){
        userService.createUser(createUserRequestDTO);
    }

    @PutMapping("/update")
    public void updateUserPassword(@RequestBody UpdateUserPasswordRequestDTO updateUserPasswordDTO){
        userService.updateUser(updateUserPasswordDTO);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody DeleteUserRequestDTO deleteUserDTO){
        userService.deleteUser(deleteUserDTO);
    }
}
