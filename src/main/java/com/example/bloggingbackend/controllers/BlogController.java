package com.example.bloggingbackend.controllers;

import com.example.bloggingbackend.dto.CreateBlogRequestDTO;
import com.example.bloggingbackend.dto.DeleteBlogRequestDTO;
import com.example.bloggingbackend.dto.UpdateBlogRequestDTO;
import com.example.bloggingbackend.services.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    private final Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogService blogService;

    @PostMapping("/create")
    public void createBlog(@RequestBody CreateBlogRequestDTO createBlogRequestDTO){
        logger.info(createBlogRequestDTO.getUserId());
        blogService.createBlog(createBlogRequestDTO);
    }

    @PutMapping("/update")
    public void updateBlog(@RequestBody UpdateBlogRequestDTO updateBlogRequestDTO){
        blogService.updateBlog(updateBlogRequestDTO);
    }

    @DeleteMapping("/delete")
    public void deleteBlog(@RequestBody DeleteBlogRequestDTO deleteBlogRequestDTO){
        blogService.deleteBlog(deleteBlogRequestDTO);
    }


}
