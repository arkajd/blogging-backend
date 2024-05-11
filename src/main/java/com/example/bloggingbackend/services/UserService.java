package com.example.bloggingbackend.services;

import com.example.bloggingbackend.dto.CreateUserRequestDTO;
import com.example.bloggingbackend.dto.DeleteUserRequestDTO;
import com.example.bloggingbackend.dto.UpdateUserPasswordRequestDTO;
import com.example.bloggingbackend.models.User;
import com.example.bloggingbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(CreateUserRequestDTO createUserRequestDTO) {
        User user = new User(createUserRequestDTO.getUsername(), createUserRequestDTO.getPassword());
        userRepository.save(user);
    }

    public void updateUser(UpdateUserPasswordRequestDTO updateUserPasswordDTO) {
        String username = updateUserPasswordDTO.getUsername();
        String currentPassword = updateUserPasswordDTO.getCurrentPassword();
        String newPassword = updateUserPasswordDTO.getModifiedPassword();
        User user = userRepository.findByUsername(username);

        if(user==null){
            return;
        }
        if(ObjectUtils.isEmpty(currentPassword) || ObjectUtils.isEmpty(newPassword)){
            return;
        }
        if(!user.getPassword().equals(currentPassword)){
            return;
        }
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public void deleteUser(DeleteUserRequestDTO deleteUserDTO) {
        // no delete of user
    }
}
