package com.example.bloggingbackend.controllers;

import com.example.bloggingbackend.dto.CreateCommentRequestDTO;
import com.example.bloggingbackend.dto.UpdateCommentRequestDTO;
import com.example.bloggingbackend.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public void addComment(@RequestBody CreateCommentRequestDTO createCommentRequestDTO){
        commentService.createComment(createCommentRequestDTO);
    }

    @PutMapping("/update")
    public void updateComment(@RequestBody UpdateCommentRequestDTO updateCommentRequestDTO){
        commentService.updateComment(updateCommentRequestDTO);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable String commentId, @RequestHeader(name = "userId") String userId){
        commentService.deleteComment(commentId, userId);
    }
}
