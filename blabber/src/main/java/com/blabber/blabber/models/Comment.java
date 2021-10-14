package com.blabber.blabber.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name= "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private Long id;
    @Getter @Setter @Column(name="content") @NotEmpty
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
