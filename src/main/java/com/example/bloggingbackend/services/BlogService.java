package com.example.bloggingbackend.services;

import com.example.bloggingbackend.dto.CreateBlogRequestDTO;
import com.example.bloggingbackend.dto.UpdateBlogRequestDTO;
import com.example.bloggingbackend.models.Blog;
import com.example.bloggingbackend.models.User;
import com.example.bloggingbackend.repositories.BlogRepository;
import com.example.bloggingbackend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(BlogService.class);

    public void createBlog(CreateBlogRequestDTO createBlogRequestDTO) {
        String content = createBlogRequestDTO.getContent();
        String title = createBlogRequestDTO.getTitle();
        String userId = createBlogRequestDTO.getUserId();

        Optional<User> optionalUser = userRepository.findById(Long.valueOf(userId));
        if(optionalUser.isEmpty()){
            return;
        }
        Blog blog = new Blog(title, content, optionalUser.get());
        blogRepository.save(blog);
    }

    public void updateBlog(UpdateBlogRequestDTO updateBlogRequestDTO) {
        String userId = updateBlogRequestDTO.getUserId();
        String blogId = updateBlogRequestDTO.getBlogId();
        String updatedContent = updateBlogRequestDTO.getUpdatedContent();

        Optional<User> optionalUser = userRepository.findById(Long.valueOf(userId));
        if(optionalUser.isEmpty()){
            return;
        }
        Optional<Blog> optionalBlog = blogRepository.findById(Long.valueOf(blogId));
        if(optionalBlog.isEmpty()){
            return;
        }

        Blog blog = optionalBlog.get();
        blog.setContent(updatedContent);
        blogRepository.save(blog);
    }

    public void deleteBlog(String blogId, String userId) {
        Optional<User> optionalUser = userRepository.findById(Long.valueOf(userId));
        if(optionalUser.isEmpty()){
            return;
        }
        Optional<Blog> optionalBlog = blogRepository.findById(Long.valueOf(blogId));
        if(optionalBlog.isEmpty()){
            return;
        }
        Blog existingBlog = optionalBlog.get();
        blogRepository.delete(existingBlog);

    }
}
