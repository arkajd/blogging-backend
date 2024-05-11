package com.example.bloggingbackend.services;

import com.example.bloggingbackend.dto.CreateCommentRequestDTO;
import com.example.bloggingbackend.dto.DeleteCommentRequestDTO;
import com.example.bloggingbackend.dto.UpdateCommentRequestDTO;
import com.example.bloggingbackend.models.Blog;
import com.example.bloggingbackend.models.Comment;
import com.example.bloggingbackend.models.User;
import com.example.bloggingbackend.repositories.BlogRepository;
import com.example.bloggingbackend.repositories.CommentRepository;
import com.example.bloggingbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    public void createComment(CreateCommentRequestDTO createCommentRequestDTO) {
        Optional<User> optionalUser = userRepository.findById(Long.valueOf(createCommentRequestDTO.getUserId()));
        if(optionalUser.isEmpty()){
            return;
        }
        Optional<Blog> optionalBlog = blogRepository.findById(Long.valueOf(createCommentRequestDTO.getBlogId()));
        if(optionalBlog.isEmpty()){
            return;
        }
        commentRepository.save(new Comment(createCommentRequestDTO.getContent(), optionalUser.get(), optionalBlog.get()));
    }

    public void updateComment(UpdateCommentRequestDTO updateCommentRequestDTO) {
        Optional<Comment> optionalComment = commentRepository.findById(Long.valueOf(updateCommentRequestDTO.getCommentId()));
        if(optionalComment.isPresent()){
            Comment existingComment = optionalComment.get();
            existingComment.setContent(updateCommentRequestDTO.getContent());
            commentRepository.save(existingComment);
        }
    }

    public void deleteComment(String commentId, String userId) {
        Optional<User> optionalUser = userRepository.findById(Long.valueOf(userId));
        if(optionalUser.isEmpty()){
            return;
        }
        Optional<Comment> optionalComment = commentRepository.findById(Long.valueOf(commentId));
        if(optionalComment.isPresent()){
            commentRepository.delete(optionalComment.get());
        }
    }
}
