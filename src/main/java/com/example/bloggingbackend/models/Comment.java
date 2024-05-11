package com.example.bloggingbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="T_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User commenter;

    @ManyToOne
    @JoinColumn(name="blog_id", nullable = false)
    private Blog blog;

    public Comment(String content, User commenter, Blog blog){
        this.content = content;
        this.commenter = commenter;
        this.blog = blog;
    }

}
