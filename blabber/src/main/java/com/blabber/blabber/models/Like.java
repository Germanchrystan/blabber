package com.blabber.blabber.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name= "postLike")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="postId", referencedColumnName = "postId")
    private Post post;
}
