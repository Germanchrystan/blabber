package com.blabber.blabber.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long postId;
    @Column(name="content")
    @NotBlank
    private String content;
    @Column(name="date")
    private Instant createdDate;
    @Column(name="edited")
    private boolean edited;
    @Column(name="likeCount")
    private int likeCount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    /*
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "likeId", referencedColumnName = "likeId")
    private Like like;
    */
}
