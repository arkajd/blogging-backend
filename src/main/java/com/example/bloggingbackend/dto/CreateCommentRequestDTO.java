package com.example.bloggingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequestDTO {
    private String content;
    private String userId;
    private String blogId;
}
