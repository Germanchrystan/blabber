package com.blabber.blabber.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private int id;
    @Getter @Setter @Column(name="userId")
    private int userId;
    @Getter @Setter @Column(name="content")
    private String content;
    @Getter @Setter @Column(name="date")
    private Date publishDate;
    @Getter @Setter @Column(name="likes")
    private int likes;
    @Getter @Setter @Column(name="edited")
    private boolean edited;
}
