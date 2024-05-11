package com.example.bloggingbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPasswordRequestDTO {

    private String username;
    private String currentPassword;
    private String modifiedPassword;
}
