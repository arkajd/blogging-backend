package com.example.bloggingbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_blog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private int upVote;
    private int downVote;

    public Blog(String title, String content, User user){
        this.title = title;
        this.content = content;
        this.user = user;
        this.date = new Date();
    }
}
