package com.blabber.blabber.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private int id;
    @Getter @Setter @Column(name="userId")
    private int userId;
    @Getter @Setter @Column(name="postId")
    private int postId;
    @Getter @Setter @Column(name="content")
    private String content;
}
